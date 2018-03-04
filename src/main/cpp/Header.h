#pragma once
#include <stdio.h>
#include <fstream> // need this to use fstream objects
# include <iostream>
# include <string>
# include <time.h>

using namespace std;

class StickNoidG
{
public:
	int getSight();
	void setSight(int &num);
	int getHairA();
	void setHairA(int &num);
	int getHairB();
	void setHairB(int &num);
	int getHeightA();
	void setHeightA(int &num);
	int getHeightB();
	void setHeightB(int &num);
	int getHeightC();
	void setHeightC(int &num);
	int getEye();
	void setEye(int &num);

private:
	int sight;
	int hairA;
	int hairB;
	int heightA;
	int heightB;
	int heightC;
	int eye;
	int gender;
};

//phenotype class
class Pheno
{
public:
	int getSight();
	void setSight(int &num);
	int getHeight();
	void setHeight(int &num);
	int getEye();
	void setEye(int &num);
	int getHair();
	void setHair(int &num);
	int getGender();
	void setGender(int &num);
private:

	int nearSight;
	int height;
	int eye;
	int hair;
	int gender;
};

//application wrapper


class AppWrap
{
public:
	void runApp(string input, string output);
	void loadData();
	void p2gParents();
	void g2ProgenyG();
	void pheSim();
	void writeData();
private:
	StickNoidG motherGeno;
	StickNoidG fatherGeno;
	StickNoidG progeny[50];
	Pheno phenoProg[50];
	Pheno motherPheno;
	Pheno FatherPheno;

	fstream inFile;
	fstream outFile;
};
