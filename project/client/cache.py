
from response import responseObj
import re
import sqlite3

MODIFYING_KEYWORDS = ["CREATE", "MERGE", "SET", "DELETE"]

class cacheDB:
    def __init__(self) -> None:
        print("Initializing client cache database (SQLite)")
        # TODO: initialize sqlite db here

    def clear_all_cache(self) -> bool:
        wiped: bool = False
        print("Wiping all cached responses")
        # TODO: delete all rows in the db cache table
        return wiped
    
    def get_query_response(self, query: str) -> responseObj:
        """Get response matching to the query from the cache.

        Args:
            query (str): a string of query that doesn't contain modifying operators.
        
        Returns:
            responseObj: the matching response to the query. If none exists, return None.

        """
        response: responseObj = None
        # TODO: get matching row item corresponding to query from the SQL table
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
        # TODO: put/update target query and its response in the SQL table
        return operationCompleted
    
    def __is_cacheable(query: str, response: responseObj) -> bool:
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
        # TODO: make sure keywords are actual operands an not properties (e.g. node name)
        keywords = '|'.join(MODIFYING_KEYWORDS)
        containsKeyword = bool(re.match(
            pattern='^(?=.*('+keywords+')).*$',
            string=query,
            flags=re.IGNORECASE
        ))
        if containsKeyword:
            return False
        return True