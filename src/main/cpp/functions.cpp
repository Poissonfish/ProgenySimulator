#include "Header.h"


void AppWrap::runApp(string input, string output)
{

	inFile.open(input, std::fstream::in);
	outFile.open(output, std::fstream::out);
	loadData();
	p2gParents();
	g2ProgenyG();
	pheSim();

	writeData();
	outFile.close();
	inFile.close();
}

void AppWrap::loadData()
{
	int temp;
	string buffer;
	inFile >> temp;
	motherPheno.setHair(temp);
	inFile >> temp;
	motherPheno.setEye(temp);
	inFile >> temp;
	motherPheno.setSight(temp);
	inFile >> temp;
	motherPheno.setHeight(temp);
	inFile >> temp;
	FatherPheno.setHair(temp);
	inFile >> temp;
	FatherPheno.setEye(temp);
	inFile >> temp;
	FatherPheno.setSight(temp);
	inFile >> temp;
	FatherPheno.setHeight(temp);
}

void AppWrap::p2gParents()
{
	int per_50 = 0, temp = 69;
	//doing eye color
	if (FatherPheno.getEye() == 1)
	{
		//blue eye is reccisive
		temp = 0;
		fatherGeno.setEye(temp);
	}
	else if (FatherPheno.getEye() == 2)
	{
		//green eye
		temp = 1;
		fatherGeno.setEye(temp);
	}
	else if (FatherPheno.getEye() == 3)
	{
		//brown eye
		temp = 2;
		fatherGeno.setEye(temp);
	}

	//now for mother
	if (motherPheno.getEye() == 1)
	{
		//blue eye is reccisive
		temp = 0;
		motherGeno.setEye(temp);
	}
	else if (motherPheno.getEye() == 2)
	{
		//green eye
		temp = 1;
		motherGeno.setEye(temp);
	}
	else if (motherPheno.getEye() == 3)
	{
		//brown eye
		temp = 2;
		motherGeno.setEye(temp);
	}

	//now hair color
	//black hair
	if (FatherPheno.getHair() == 3)
	{
		temp = 2;
		fatherGeno.setHairA(temp);
		fatherGeno.setHairB(temp);
	}
	else if (FatherPheno.getHair() == 2)
	{
		//brown hair
		temp = 2;
		fatherGeno.setHairA(temp);
		temp = rand() % 2; // either 0 or 1
		fatherGeno.setHairB(temp);
	}
	else if (FatherPheno.getHair() == 1)
	{
		//blonde hair
		temp = 1;
		fatherGeno.setHairA(temp);
		temp = rand() % 2;
		fatherGeno.setHairB(temp);
	}

	//black hair
	if (motherPheno.getHair() == 3)
	{
		temp = 2;
		motherGeno.setHairA(temp);
		motherGeno.setHairB(temp);
	}
	else if (FatherPheno.getHair() == 2)
	{
		//brown hair
		temp = 2;
		motherGeno.setHairA(temp);
		temp = rand() % 2; // either 0 or 1
		motherGeno.setHairB(temp);
	}
	else if (motherPheno.getHair() == 1)
	{
		//blonde hair
		temp = 1;
		motherGeno.setHairA(temp);
		temp = rand() % 2;
		motherGeno.setHairB(temp);

	}
	//now sight
	//can see
	if (motherPheno.getSight() == 1)
	{
		temp = rand() % 2 + 1; // either 1 or 2
		motherGeno.setSight(temp);
	}
	else if (motherPheno.getSight() == 2)
	{
		temp = 0;
		motherGeno.setSight(temp);
	}
	//now for father
	//can see
	if (FatherPheno.getSight() == 1)
	{
		temp = rand() % 2 + 1; // either 1 or 2
		fatherGeno.setSight(temp);
	}
	else if (FatherPheno.getSight() == 2)
	{
		temp = 0;
		fatherGeno.setSight(temp);
	}

	//now for height
	//mother
	if (motherPheno.getHeight() > 175)
	{
		temp = 2;
		motherGeno.setHeightA(temp);
		motherGeno.setHeightB(temp);
		motherGeno.setHeightC(temp);
	}
	else if (motherPheno.getHeight() > 162)
	{
		temp = 2;
		motherGeno.setHeightA(temp);
		motherGeno.setHeightB(temp);
		temp = 1;
		motherGeno.setHeightC(temp);
	}
	else if (motherPheno.getHeight() > 149)
	{
		temp = 2;
		motherGeno.setHeightA(temp);
		motherGeno.setHeightB(temp);
		temp = 0;
		motherGeno.setHeightC(temp);
	}
	else if (motherPheno.getHeight() > 124)
	{
		temp = 2;
		motherGeno.setHeightA(temp);
		temp = 1;
		motherGeno.setHeightB(temp);
		temp = 0;
		motherGeno.setHeightC(temp);
	}
	else if (motherPheno.getHeight() > 99)
	{
		temp = 2;
		motherGeno.setHeightA(temp);
		temp = 0;
		motherGeno.setHeightB(temp);
		motherGeno.setHeightC(temp);
	}
	else if (motherPheno.getHeight() < 99)
	{
		temp = 1;
		motherGeno.setHeightA(temp);
		temp = 0;
		motherGeno.setHeightB(temp);
		motherGeno.setHeightC(temp);
	}

	//now for height
	//father
	if (FatherPheno.getHeight() > 175)
	{
		temp = 2;
		fatherGeno.setHeightA(temp);
		fatherGeno.setHeightB(temp);
		fatherGeno.setHeightC(temp);
	}
	else if (FatherPheno.getHeight() > 162)
	{
		temp = 2;
		fatherGeno.setHeightA(temp);
		fatherGeno.setHeightB(temp);
		temp = 1;
		fatherGeno.setHeightC(temp);
	}
	else if (FatherPheno.getHeight() > 149)
	{
		temp = 2;
		fatherGeno.setHeightA(temp);
		fatherGeno.setHeightB(temp);
		temp = 0;
		fatherGeno.setHeightC(temp);
	}
	else if (FatherPheno.getHeight() > 124)
	{
		temp = 2;
		fatherGeno.setHeightA(temp);
		temp = 1;
		fatherGeno.setHeightB(temp);
		temp = 0;
		fatherGeno.setHeightC(temp);
	}
	else if (FatherPheno.getHeight() > 99)
	{
		temp = 2;
		fatherGeno.setHeightA(temp);
		temp = 0;
		fatherGeno.setHeightB(temp);
		fatherGeno.setHeightC(temp);
	}
	else if (FatherPheno.getHeight() < 99)
	{
		temp = 1;
		fatherGeno.setHeightA(temp);
		temp = 0;
		fatherGeno.setHeightB(temp);
		fatherGeno.setHeightC(temp);
	}
	return;
}

void AppWrap::g2ProgenyG()
{
	int i = 0, m = 0, f = 0, trait = 0;
	for (; i < 50; i++)
	{
		//eye color genes
		if (motherGeno.getEye() == 2)
		{
			m = 1;
		}
		else if (motherGeno.getEye() == 1)
		{
			m = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			m = 0;
		}

		//male eye color

		if (fatherGeno.getEye() == 2)
		{
			f = 1;
		}
		else if (fatherGeno.getEye() == 1)
		{
			f = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			f = 0;
		}
		trait = m + f;
		progeny[i].setEye(trait);

		//hair color A
		if (motherGeno.getHairA() == 2)
		{
			m = 1;
		}
		else if (motherGeno.getHairA() == 1)
		{
			m = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			m = 0;
		}

		//male hair A

		if (fatherGeno.getHairA() == 2)
		{
			f = 1;
		}
		else if (fatherGeno.getHairA() == 1)
		{
			f = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			f = 0;
		}
		trait = m + f;
		progeny[i].setHairA(trait);

		//hair B

		if (motherGeno.getHairB() == 2)
		{
			m = 1;
		}
		else if (motherGeno.getHairB() == 1)
		{
			m = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			m = 0;
		}

		//male hair A

		if (fatherGeno.getHairB() == 2)
		{
			f = 1;
		}
		else if (fatherGeno.getHairB() == 1)
		{
			f = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			f = 0;
		}
		trait = m + f;
		progeny[i].setHairB(trait);

		//height A
		if (motherGeno.getHeightA() == 2)
		{
			m = 1;
		}
		else if (motherGeno.getHeightA() == 1)
		{
			m = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			m = 0;
		}

		//male hair A

		if (fatherGeno.getHeightA() == 2)
		{
			f = 1;
		}
		else if (fatherGeno.getHeightA() == 1)
		{
			f = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			f = 0;
		}
		trait = m + f;
		progeny[i].setHeightA(trait);

		//height B
		if (motherGeno.getHeightB() == 2)
		{
			m = 1;
		}
		else if (motherGeno.getHeightB() == 1)
		{
			m = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			m = 0;
		}

		//male hair A

		if (fatherGeno.getHeightB() == 2)
		{
			f = 1;
		}
		else if (fatherGeno.getHeightB() == 1)
		{
			f = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			f = 0;
		}
		trait = m + f;
		progeny[i].setHeightB(trait);

		//height c
		if (motherGeno.getHeightC() == 2)
		{
			m = 1;
		}
		else if (motherGeno.getHeightC() == 1)
		{
			m = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			m = 0;
		}

		//male hair A

		if (fatherGeno.getHeightC() == 2)
		{
			f = 1;
		}
		else if (fatherGeno.getHeightC() == 1)
		{
			f = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			f = 0;
		}
		trait = m + f;
		progeny[i].setHeightC(trait);

		//now for sight

		if (motherGeno.getSight() == 2)
		{
			m = 1;
		}
		else if (motherGeno.getSight() == 1)
		{
			m = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			m = 0;
		}

		//male hair A

		if (fatherGeno.getSight() == 2)
		{
			f = 1;
		}
		else if (fatherGeno.getSight() == 1)
		{
			f = rand() % 2; //50% chance of 1 50% chance of 0
		}
		else
		{
			f = 0;
		}
		trait = m + f;
		progeny[i].setSight(trait);


	}


}

void AppWrap::pheSim()
{
	int i = 0, h1 = 0, h2 = 0, h3 = 0, temp = 0;
	while (i < 50)
	{
		if (progeny[i].getEye() == 2)
		{
			//set eye to brown
			temp = 3;
			phenoProg[i].setEye(temp);
		}
		else if (progeny[i].getEye() == 1)
		{
			//set to green
			temp = 2;
			phenoProg[i].setEye(temp);
		}
		else if (progeny[i].getEye() == 0)
		{
			//set to blue
			temp = 1;
			phenoProg[i].setEye(temp);
		}

		//now time for sight
		if (progeny[i].getSight() == 0)
		{
			//near sighted double reccisive
			temp = 2;
			phenoProg[i].setSight(temp);
		}
		else
		{
			//good eye sight
			temp = 1;
			phenoProg[i].setSight(temp);
		}

		//now time for hair
		if ((progeny[i].getHairA() + progeny[i].getHairA()) > 3)
		{
			temp = 3;
			phenoProg[i].setHair(temp);
		}
		else if ((progeny[i].getHairA() + progeny[i].getHairA()) > 1)
		{
			temp = 2;
			phenoProg[i].setHair(temp);
		}
		else
		{
			temp = 1;
			phenoProg[i].setHair(temp);
		}

		h1 = 50 * progeny[i].getHeightA();
		h2 = 25 * progeny[i].getHeightB();
		h3 = 13 * progeny[i].getHeightC();
		temp = rand() % 12 - 6;
		temp = temp + h1 + h2 + h3;
		phenoProg[i].setHeight(temp);
		i++;
	}
}

void AppWrap::writeData()
{
	int i = 0, temp = 0;
	for (; i < 16; i++)
	{
		temp = phenoProg[i].getHair();
		outFile << temp << endl;
		temp = phenoProg[i].getEye();
		outFile << temp << endl;
		temp = phenoProg[i].getSight();
		outFile << temp << endl;
		temp = phenoProg[i].getHeight();
		outFile << temp<< endl;
	}
	return;
}
