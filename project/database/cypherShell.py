import subprocess
import time

# time.sleep(5)
ret: subprocess.CompletedProcess = subprocess.run(
    [
        "docker",
        "exec",
        "--interactive",
        "--tty",
        "server1",
        "cypher-shell",
        "-u",
        "neo4j",
        "-p",
        "password",
    ],
    # capture_output=True,
)
# print("\n\n" + str(ret.returncode) + "\n" + str(ret.stderr) + "\n\n")
