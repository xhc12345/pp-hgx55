import tkinter as tk


# Function to update the variable value
def update_variable():
    global my_variable
    my_variable += 1
    label.config(text=f"Variable Value: {my_variable}")


# Initialize the tkinter window
window = tk.Tk()
window.title("Variable Changer")

# Initialize the variable
my_variable = 0

# Create a label to display the variable
label = tk.Label(window, text=f"Variable Value: {my_variable}")
label.pack()

# Create a button to update the variable
button = tk.Button(window, text="Change Variable", command=update_variable)
button.pack()

# Start the tkinter main loop
window.mainloop()
