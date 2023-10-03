import sys
import subprocess


class Shell:
    def __init__(self) -> None:
        self.cmdHeader: str = "$: "
        self.commandHistory: list[str] = []

    def start(self):
        print("============================================")
        print("||            CLIENT LAUNCHING            ||")
        print("============================================")

        # print("||              INITIALIZAED              ||")
        # print("============================================")

        self.__SHOW_HELP()

        while True:
            try:
                cmd: str = input(self.cmdHeader)
            except EOFError:
                self.__EXIT()
            except:
                print("\nUnsupported input")
                continue

            # print("command: " + cmd)

            tokens: list[str] = cmd.split(sep=" ")
            cmdType: str = tokens[0] if len(tokens) else None

            if cmdType.lower() == "exit":
                self.__EXIT()

            elif cmdType == "help":
                self.__SHOW_HELP()

            elif cmdType == "history":
                print(self.commandHistory[-10:])

            elif cmdType == "cql":
                if len(tokens) < 2 or len(tokens[1]) == 0:
                    self.__ERROR(
                        "cql command must be followed by a one-line cypher query, no double space any where"
                    )
                    continue
                query: str = " ".join(tokens[1:])
                self.__cql(query)

            elif cmdType == "path":
                if len(tokens) != 2 or len(tokens[1]) == 0:
                    self.__ERROR("path command must have 1 and only 1 argument")
                    continue
                path: str = tokens[1]
                self.__path(path)

            else:
                print("Unsupported input: " + cmd + "\n")
                continue

            self.commandHistory.append(cmd)

    def __path(self, path: str):
        # print("taking input from path=" + path)
        content: str = None
        try:
            fp = open(path, "r")
            content = fp.read()
            print("Input file content: " + content)
            fp.close()
        except FileNotFoundError:
            self.__ERROR("path not found: " + path)
        if not content:
            self.__ERROR("file is empty/unreadable at " + path)
            return
        success = self.__write_to_IO(input=content)
        if not success:
            return
        self.__start_lexparse()
        stderr: str = self.__check_stderr_content()
        if len(stderr):
            print(stderr, file=sys.stderr)
        else:
            print("Input is valid\n")

    def __cql(self, query: str):
        success = self.__write_to_IO(input=query)
        if not success:
            return
        self.__start_lexparse()
        stderr: str = self.__check_stderr_content()
        if len(stderr):
            print(stderr, file=sys.stderr)
        else:
            print("Input is valid\n")

    def __write_to_IO(self, input: str, path: str = "IO/input.cql") -> bool:
        try:
            fp = open(path, "w")
            # print("writing\n'" + input + "'\nto " + path)
            fp.write(input)
            fp.close()
            return True
        except FileNotFoundError:
            self.__ERROR("path not found: " + path)
            return False

    def __start_lexparse(self):
        # launches lexparse
        subprocess.run(["bash", "./lexparse/run.sh"])

    def __check_stderr_content(self) -> str:
        # checks if there are content in IO/stderr.txt
        try:
            fp = open("IO/stderr.txt", "r")
            content: str = fp.read()
            if not content:
                content = ""
            # print("\n" + content, file=sys. stderr)
            fp.close()
            return content
        except FileNotFoundError:
            return "CLIENT ERROR: IO/stderr.txt not found"

    def __ERROR(self, msg: str):
        print("CLIENT ERROR: " + msg, file=sys.stderr)

    def __SHOW_HELP(self):
        print("AVAILABLE COMMANDS:")
        print("- path <path_to_cql_or_txt_file>")
        print(
            "\tpoints the input for client to a cql or txt file (no white space allowed in path)"
        )
        print("- cql <cypher_query>")
        print("\tgives the client the query to process directly (has to be one-liner)")
        print("- exit")
        print("\texits the program")
        print("- help")
        print("\tprints this message again and print list of all commands")
        print()

    def __EXIT(self):
        print("Bye!")
        exit()
