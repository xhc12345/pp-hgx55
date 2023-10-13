import sys
from typing import Tuple
import requests

NO_CONNECTION = -1
STATUS_OK = 200
STATUS_BAD_REQUEST=400
STATUS_NOT_FOUND=404


URL = "http://localhost:8080"

def ping_server():
    print("pinging server")
    statusCode, success, message = __GET('/ping')
    if statusCode==NO_CONNECTION:
        __ERROR("No connection can be establish to the server, please make sure it's running.")
        return False
    elif statusCode == STATUS_NOT_FOUND or not success:
        __ERROR("Invalid request, can't ping the server. Is the correct server hosted on "+URL+"?")
        return False
    else:
        print("Server is live at "+URL+"! Additionally, server responded to us: "+message)
        return True

def send_cql_cmd(query:str):
    print("sending cypher query to server")
    statusCode, success, message = __POST('/run', query)
    if statusCode == STATUS_BAD_REQUEST or not success:
        __ERROR("Problem with the entry:\n"+message)
    else:
        print("Success:\n"+message)
    

def __GET(route:str) -> Tuple[int, bool, str]:
    print("sending GET request")
    target = URL+route
    try:
        response:requests.Response = requests.get(target)
    except:
        return NO_CONNECTION, False, None
    # response:requests.Response = requests.get(target)
    code:int = response.status_code
    # if code!=STATUS_OK:
    #     return code, False, None
    responseBody:dict = response.json()
    success:bool = responseBody.get('success')
    message:str = responseBody.get('message')
    return code, success, message

def __POST(route:str, body:str) -> Tuple[int, bool, str]:
    print("sending POST request")
    target = URL+route
    response:requests.Response = requests.post(target, data=body)
    code:int = response.status_code
    # if code!=STATUS_OK:
    #     return code, False, None
    responseBody:dict = response.json()
    success:bool = responseBody.get('success')
    message:str = responseBody.get('message')
    return code, success, message

def __ERROR(msg:str):
    print("REQUEST ERROR:", msg, file=sys.stderr)
