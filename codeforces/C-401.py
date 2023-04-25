from io import StringIO

z, o = [int(i) for i in input().split()]



def printfirst():
    return "10"

def printsecond():
    return "110"

def solve(z, o):
    ans = StringIO()
    if z > o: 
        ans.write("0")
        z-=1
    while z and o:
        if o > z: 
            ans.write(printsecond())
            o -=2
        else: 
            ans.write(printfirst())
            o -= 1
        z -=1
    for i in range(o):
        ans.write("1")
    print(ans.getvalue())



    
if __name__ == "__main__":
    if z > o + 1 or o > 2*z + 2:
        print(-1)
    else: 
        solve(z, o)
