#rail fence method

#get input from user
plain_text = "Find Me If you Can    "
plain_text = "".join(plain_text.strip().split()).lower()
print("You entered the following plaintext: "+plain_text)

#accept depth from user
depth = int(input("Enter depth value, m: "))
print(f"You entered depth, m = {depth}")

#find length of the plain_text
p_t_length = len(plain_text)
print(f"Length of plaintext is: {p_t_length}")

