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
                if len(tokens) != 2 or len(tokens[1]) == 0:
                    self.__ERROR("path command must have 1 and only 1 argument")
                    continue
                path: str = tokens[1]
                self.__path(path)

            else:
                print("\nUnsupported input" + cmd)
                continue

            self.commandHistory.append(cmd)

    def __path(self, path: str):
        print("taking input from path=" + path)
        content: str = None

        try:
            fp = open(path, "r")
            content = fp.read()
            print("\n" + content)
            fp.close()
        except FileNotFoundError:
            self.__ERROR("path not found: " + path)

        if content:
            success = self.__write_to_IO(input=content)
            if success:
                # TODO: launch lexparse and check IO/stderr.txt
                pass

    def __start_lexparse(self):
        pass

    def __write_to_IO(self, input: str, path: str = "IO/input.cql") -> bool:
        try:
            fp = open(path, "w")
            print("writing\n" + input + "\nto " + path)
            fp.write(input)
            fp.close()
            return True
        except FileNotFoundError:
            self.__ERROR("path not found: " + path)
            return False

    def __ERROR(self, msg: str):
        print("ERROR: " + msg, file=sys.stderr)

    def __SHOW_HELP(self):
        print("available commands:")
        print("- path <path_to_cql_or_txt_file>")
        print(
            "\tpoints the input for client to a cql or txt file (no white space allowed)"
        )
        print("- cql <cypher_query>")
        print("\tgives the client the query to process directly")
        print("- exit")
        print("\texits the program")
        print("- help")
        print("\tprints this message again and print list of all commands")

    def __EXIT(self):
        print("Bye!")
        exit()
