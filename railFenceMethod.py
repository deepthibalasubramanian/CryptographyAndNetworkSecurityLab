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

#find dimension of matrix
dim = p_t_length//depth
#print(dim)
rem = p_t_length%depth
#print(rem)

#create matrix
matrix = [depth][dim+1]
counter=0
for i in range(depth):
    for j in range(dim+1):
        matrix[i][j].append(plain_text[counter])
        print(matrix[i][j])
        counter+=1
