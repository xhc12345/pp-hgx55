with open('out.txt', 'r') as f:
    content: str = f.read()
    if '' in content:
        print("HAS ERROR")
    else:
        print("NO ERROR")