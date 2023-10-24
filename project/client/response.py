class responseObj:
    def __init__(self, code: int, responseBody:dict) -> None:
        self.code:int = code
        self.success:bool = responseBody.get('success', False)
        self.message:str = responseBody.get('message', "Failed to create response object")
        self.clearCache:bool = responseBody.get('clearCache', False)

    def __str__(self) -> str:
        return '{"code":"'+self.code+'", "success":"'+self.success+'", "message":"'+self.message+'", "clearCache":"'+self.clearCache+'"}'

    def toTuple(self):
        ret = (self.code, self.success, self.message, self.clearCache)
        return ret