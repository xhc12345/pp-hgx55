import tkinter as tk


class Client(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("hgx55_project_client")
        self.geometry("500x500")

        # define IntVar() variables A and B
        self.i = tk.IntVar()
        self.i.set(25)

        # assign methods to notify on IntVar() variables
        self.i.trace_add("write", self.up)

        self.create_widgets()

    def change(self, var: tk.IntVar, n: int):
        val = var.get()
        print("clicked, i=" + str(self.i.get()))
        val += n
        var.set(val)
        print("i set to " + str(self.i.get()))

    def create_widgets(self):
        self.i_label = tk.Entry(self, textvariable=self.i)
        self.curr_label = tk.Label(self, text=f"Current: {self.i.get()}")
        self.add = tk.Button(self, text="+1", command=lambda: self.change(self.i, 1))
        self.sub = tk.Button(self, text="-1", command=lambda: self.change(self.i, -1))

        self.i_label.grid(row=0, column=0, padx=5, pady=5)
        self.curr_label.grid(row=1, column=0, columnspan=2, rowspan=2, padx=5, pady=5)
        self.add.grid(row=3, column=0, padx=5, pady=5)
        self.sub.grid(row=3, column=1, padx=5, pady=5)

    def up(self, *args):
        print("i updated to " + str(self.i.get()))
        self.curr_label.config(text=f"Current: {self.i.get()}")
