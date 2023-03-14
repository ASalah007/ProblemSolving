from io import StringIO


def main():
    m, s = [int(i) for i in input().split()]
    if s > 9 * m or (s == 0 and m > 1):
        print(-1, -1)
        return

    if s == 0 and m == 1:
        print(0, 0)
        return

    mx = StringIO()

    for i in range(m):
        nxt = 9 if s - 9 > 0 else s
        s -= nxt
        mx.write(str(nxt))

    mn = mx.getvalue()[::-1]

    if mn[0] == "0":
        i = 0
        while mn[i] == "0":
            i += 1
        mn = "1" + mn[1:i] + str(int(mn[i])-1) + mn[i+1:]

    print(mn, mx.getvalue())


if __name__ == "__main__":
    main()
