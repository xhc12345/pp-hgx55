import sys
from typing import Tuple
import requests
from cache import cacheDB
from response import responseObj

NO_CONNECTION = -1
STATUS_OK = 200
STATUS_BAD_REQUEST=400
STATUS_NOT_FOUND=404


URL = "http://localhost:8080"

def ping_server() -> bool:
    print("pinging server")
    response:responseObj = __GET('/ping')
    if response.code == NO_CONNECTION:
        __ERROR("No connection can be establish to the server, please make sure it's running.")
        return False
    elif response.code == STATUS_NOT_FOUND or not response.success:
        __ERROR("Invalid request, can't ping the server. Is the correct server hosted on "+URL+"?")
        return False
    else:
        print("Server is live at "+URL+"! Additionally, server responded to us: "+response.message)
        return True


def send_cql_cmd(query:str, cache: cacheDB):
    print("Searching for cached responses for this query...")
    response:responseObj = cache.get_query_response(query)
    if not response:
        print("No cache found, sending cypher query to server")
        response:responseObj = __POST('/run', query)
        if response.clearCache:
            _cleared:bool = cache.clear_all_cache()
        else:
            if not response.success:    # save bad requests too to avoid sending it to server
                cache.put_query_reponse(query, response)
            else: 
                cache.put_query_reponse(query, response)
    # check if response has any problems
    if response.code == STATUS_BAD_REQUEST or not response.success:
        __ERROR("Problem with the entry:\n"+response.message)
    else:
        print("Success:\n"+response.message)
    

def __GET(route:str) -> responseObj:
    print("sending GET request")
    target = URL+route
    try:
        response:requests.Response = requests.get(target)
    except:
        # return NO_CONNECTION, False, None, False
        return responseObj(NO_CONNECTION, {"success":False, "message":None, "clearCache":True})
    code:int = response.status_code
    responseBody:dict = response.json()
    return responseObj(code, responseBody)

def __POST(route:str, body:str) -> responseObj:
    print("sending POST request")
    target = URL+route
    response:requests.Response = requests.post(target, data=body)
    code:int = response.status_code
    responseBody:dict = response.json()
    return responseObj(code, responseBody)

def __ERROR(msg:str):
    print("REQUEST ERROR:", msg, file=sys.stderr)
