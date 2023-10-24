class responseObj:
    def __init__(self, code: int, responseBody:dict) -> None:
        self.code:int = code
        self.success:bool = responseBody.get('success', False)
        self.message:str = responseBody.get('message', "Failed to create response object")
        self.clearCache:bool = responseBody.get('clearCache', False)