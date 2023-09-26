# client app
import tkinter as tk
from tkinter.ttk import *


# creating main tkinter window/toplevel
root = tk.Tk()
i = 25

# this will create a label widget
l1 = Label(root, text="First:")
l2 = Label(root, text="Second:")

# grid method to arrange labels in respective
# rows and columns as specified
l1.grid(row=0, column=0, pady=2)
l2.grid(row=1, column=0, pady=2)

# entry widgets, used to take entry from user
e1 = Entry(root)
e2 = Entry(root)

# this will arrange entry widgets
e1.grid(row=0, column=1, pady=2)
e2.grid(row=1, column=1, pady=2)

# checkbutton widget
c1 = Checkbutton(root, text="Preserve")
c1.grid(row=2, column=0, columnspan=2)

# setting image with the help of label
Label(root, text=f"{i}").grid(row=0, column=2, columnspan=2, rowspan=2, padx=5, pady=5)


def change(root: tk.Tk, var: int, amount):
    var += amount


# button widget
b1 = Button(root, text="+1", command=change(root, i, 1))
b2 = Button(root, text="-1", command=change(root, i, -1))

# arranging button widgets
b1.grid(row=2, column=2)
b2.grid(row=2, column=3)

# infinite loop which can be terminated by keyboard
# or mouse interrupt
tk.mainloop()
