# include "Header.h"
# include "functions.cpp"
# include "classFunctions.cpp"

int main(int argc, char* argv[])
{
	AppWrap A;
	srand(time(NULL));
	cout << argv[1] << endl;
	cout << argv[2] << endl;
	A.runApp(argv[1], argv[2]);
	return 0;
}
