#include<bits/stdc++.h>
using namespace std;

void FThEE(vector<vector<int>> &G, int r, int &rr, int &cc)
{
	rr = -1; // indicate error
	cc = -1;
	int Nv = G.size();
	int acc = 0;
	for (int i=0; i<Nv; i++)
	{
		if (G[i].empty())
		{
			continue;
		}

		if (acc+G[i].size() >= r)
		{
			rr = i;
			cc = r - acc-1;
			break;
		}
		else
		{
			acc += G[i].size();
		}
	}
}

void NV(vector<vector<int>> &G, int &v, int &NV, int &NE)
{
	NV = 0;
	NE = 0;
	int NG = G.size();
	for (int i=0; i < NG; i++)
	{
		if (!G[i].empty())
		{
			NV++;
			v = i;
			NE += G[i].size();
		}
	}
}
int main()
{
	ifstream infile;
	infile.open("mC.txt");
	vector<vector<int>> G;
	string L;
	std::stringstream ss;
	vector<int> verL;
	while(getL(infile, L))
	{
		ss << L;
		int n;
		ss >> n;
		int T;
		while(ss >> T)
		{
			verL.push_back(T);
		}
		G.push_back(verL);

		verL.clear();
		ss.clear();
	}
	infile.close();
	return 0;
}