#include <stdio.h>
#include <string.h>

#define MEMORY_SIZE 10

int main()
{
	char mem[MEMORY_SIZE], *ptr;
	memset(mem, 0, sizeof(mem));
	ptr = mem;
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	while (*ptr)
	{
	++ptr;
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++ptr;
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++ptr;
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++ptr;
	++(*ptr);
	--ptr;
	--ptr;
	--ptr;
	--ptr;
	--(*ptr);
	}
	++ptr;
	++(*ptr);
	++(*ptr);
	printf("%c", *ptr);
	++ptr;
	++(*ptr);
	printf("%c", *ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	printf("%c", *ptr);
	printf("%c", *ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	printf("%c", *ptr);
	++ptr;
	++(*ptr);
	++(*ptr);
	printf("%c", *ptr);
	--ptr;
	--ptr;
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	printf("%c", *ptr);
	++ptr;
	printf("%c", *ptr);
	++(*ptr);
	++(*ptr);
	++(*ptr);
	printf("%c", *ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	printf("%c", *ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	--(*ptr);
	printf("%c", *ptr);
	++ptr;
	++(*ptr);
	printf("%c", *ptr);
	++ptr;
	printf("%c", *ptr);
return 0;
}