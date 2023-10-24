
from response import responseObj
import sqlite3


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
        operationCompleted: bool = False
        # TODO: put/update target query and its response in the SQL table
        return operationCompleted