
from response import responseObj
import re
import sqlite3

MODIFYING_KEYWORDS = ["CREATE", "MERGE", "SET", "DELETE", "REMOVE"]

DEFAULT_DB_NAME = 'clientCache.db'
DEFAULT_TABLE_NAME = "cache_table"

GRAPH_KEYWORD = "GRAPH"

class cacheDB:
    def __init__(self, dbName: str = DEFAULT_DB_NAME, tableName: str = DEFAULT_TABLE_NAME) -> None:
        self.dbName:str = 'cache/'+dbName
        self.tableName:str = tableName
        print("Initializing client cache database (SQLite)")
        self.connection = sqlite3.connect(self.dbName)
        cursor = self.connection.cursor()
        # Create the table with the keys needed to represent query & response
        cursor.execute(f'''
            CREATE TABLE IF NOT EXISTS {self.tableName} (
                query TEXT PRIMARY KEY,
                code INTEGER,
                success BOOLEAN,
                message TEXT,
                clearCache BOOLEAN
            )
        ''')
        self.connection.commit() # reflect changes

    def __del__(self):
        print("Closing connection to client cache database (SQLite)")
        self.connection.close()

    def clear_all_cache(self) -> bool:
        wiped: bool = False
        print("Wiping all cached responses")
        cursor = self.connection.cursor()
        cursor.execute(f'DELETE FROM {self.tableName}')
        self.connection.commit()
        wiped = True
        return wiped

    def get_query_response(self, query: str) -> responseObj:
        """Get response matching to the query from the cache.

        Args:
            query (str): a string of query that doesn't contain modifying operators.
        
        Returns:
            responseObj: the matching response to the query. If none exists, return None.

        """
        response: responseObj = None
        # TODO: test this function
        response = self.db_fetch_row(query)
        return response
    
    def put_query_reponse(self, query: str, response: responseObj) -> bool:
        """Put a query that either fails or contains no modifying operators and its response to the cache.

        Args:
            query (str):
                a string of query.
            response (responseObj):
                responseObj correctponding containing all info of the response from the server.

        Returns:
            bool: the matching response to the query. If none exists, return None.

        """
        if not self.__is_cacheable(query, response):
            print("This command and its response can't be cached")
            return False
        operationCompleted: bool = False
        # TODO: test this function
        self.db_insert_row(query, response)
        operationCompleted = True
        return operationCompleted
    
    def db_fetch_row(self, query:str) -> responseObj:
        # get matching row item corresponding to query from the SQL table
        cursor = self.connection.cursor()
        # Execute a SELECT statement to fetch the row
        cursor.execute(f'SELECT * FROM {self.tableName} WHERE query = ?', (query,))
        row = cursor.fetchone()

        if row:
            # Extract the values for the keys
            query, code, success, message, clearCache = row
            response = responseObj(code, {"success":success, "message":message, "clearCache":clearCache})
            return response
        else:
            print("Query not found in cache:", query)
            return None
        
    def db_insert_row(self, query:str, response:responseObj):
        # put/update target query and its response in the SQL table
        cursor = self.connection.cursor()

        # Check if the query exists
        cursor.execute(f'SELECT * FROM {self.tableName} WHERE query = ?', (query,))
        existing_row = cursor.fetchone()

        if existing_row:
            # Row with the query exists, update it
            cursor.execute(
                f'''
                    UPDATE {self.tableName}
                    SET code = ?, success = ?, message = ?, clearCache = ?
                    WHERE query = ?
                ''',
                (*response.toTuple(), query)
            )
        else:
            # Row with the query doesn't exist, insert a new row
            cursor.execute(
                f'''
                    INSERT INTO {self.tableName} (query, code, success, message, clearCache)
                    VALUES (?, ?, ?, ?, ?)
                ''',
                (query, *response.toTuple())
            )

        self.connection.commit()
    
    def get_graph_response(self) -> str:
        """Get last known graph from the cache.
        
        Returns:
            str: the string form of graph JSON. If none exists, return None.

        """
        # get matching row item corresponding to query from the SQL table
        cursor = self.connection.cursor()
        # Execute a SELECT statement to fetch the row
        cursor.execute(f'SELECT * FROM {self.tableName} WHERE query = ?', (GRAPH_KEYWORD,))
        row = cursor.fetchone()

        if row:
            # Extract the values for the keys
            query, code, success, message, clearCache = row
            graph = message
            return graph
        else:
            print("Graph is not cached")
            return None
        
    def put_graph_response(self, graphJSON:str):
        # put/update target query and its response in the SQL table
        cursor = self.connection.cursor()

        # Check if the query exists
        cursor.execute(f'SELECT * FROM {self.tableName} WHERE query = ?', (GRAPH_KEYWORD,))
        existing_row = cursor.fetchone()

        if existing_row:
            # Row with the query exists, update it
            cursor.execute(
                f'''
                    UPDATE {self.tableName}
                    SET code = ?, success = ?, message = ?, clearCache = ?
                    WHERE query = ?
                ''',
                (None, None, graphJSON, None, GRAPH_KEYWORD)
            )
        else:
            # Row with the query doesn't exist, insert a new row
            cursor.execute(
                f'''
                    INSERT INTO {self.tableName} (query, code, success, message, clearCache)
                    VALUES (?, ?, ?, ?, ?)
                ''',
                (GRAPH_KEYWORD, None, None, graphJSON, None)
            )

        self.connection.commit()

    def __is_cacheable(self, query: str, response: responseObj) -> bool:
        """Checks if query contains commands that modifies the graph. If true then query non-cacheable.
        Additionally, if reponse.clearCache is true then the query is automatically non-cacheable

        Args:
            query (str):
                a string of query.
            response (responseObj):
                responseObj correctponding containing all info of the response from the server.

        Returns:
            bool: whether the query and response can be cached.

        """
        if response.clearCache:
            return False
        
        # makes sure keywords are actual operands an not properties (e.g. node name)
        # checks IO/isModifyQuery.txt to see if modify clauses are present
        with open("IO/isModifyQuery.txt", "r") as flagFile:
            content: str = flagFile.read()
            isModifyQuery: bool = 'true' in content
            if isModifyQuery:
                print("Detected modify query flag set by parser")
                return False
            else:
                return True

        # keywords = '|'.join(MODIFYING_KEYWORDS)
        # containsKeyword = bool(re.match(
        #     pattern='^(?=.*('+keywords+')).*$',
        #     string=query,
        #     flags=re.IGNORECASE
        # ))
        # if containsKeyword:
        #     return False
        
        # return True