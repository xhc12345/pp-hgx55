import sys


class Shell:
    def __init__(self) -> None:
        self.cmdHeader: str = "$: "
        self.commandHistory: list[str] = []

    def start(self):
        print("============================================")
        print("||            CLIENT LAUNCHING            ||")
        print("============================================")

        # TODO: check if lexparse is built. if not, compile it

        print("||              INITIALIZAED              ||")
        print("============================================")

        self.__SHOW_HELP()

        while True:
            try:
                cmd: str = input(self.cmdHeader)
            except EOFError:
                self.__EXIT()
            except:
                print("\nUnsupported input")
                continue

            print("command: " + cmd)

            tokens: list[str] = cmd.split(sep=" ")
            cmdType: str = tokens[0] if len(tokens) else None

            if cmdType.lower() == "exit":
                self.__EXIT()

            elif cmdType == "help":
                self.__SHOW_HELP()

            elif cmdType == "history":
                print(self.commandHistory[-10:])

            elif cmdType == "path":
                if len(tokens) != 2:
                    self.__ERROR("path command must have 1 and only 1 argument")
                    continue
                path: str = tokens[1]
                print("taking input from path=" + path)
                try:
                    fp = open(path, "r")
                    print("\n" + fp.read())
                    fp.close()
                except FileNotFoundError:
                    self.__ERROR("path not found: " + path)

            else:
                print("\nUnsupported input" + cmd)
                continue

            self.commandHistory.append(cmd)

    def __ERROR(self, msg: str):
        print("ERROR: " + msg, file=sys.stderr)

    def __SHOW_HELP(self):
        print("available commands:")
        print("- path <path_to_cql_or_txt_file>")
        print("\tpoints the input for client to a cql or txt file")
        print("- cql <cypher_query>")
        print("\tgives the client the query to process directly")
        print("- exit")
        print("\texits the program")
        print("- help")
        print("\tprints this message again and print list of all commands")

    def __EXIT(self):
        print("Bye!")
        exit()
