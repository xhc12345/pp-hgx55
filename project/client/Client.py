try:
    from gui import Client
except ModuleNotFoundError:
    print("Please install TKinter")

from cli import Shell

if __name__ == "__main__":
    # app = Client()
    # app.mainloop()

    app = Shell()
    app.start()
