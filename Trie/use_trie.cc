#include <iostream>
#include "trie.h"

using namespace std; 

int main()
{
    // Initializing Trie
    Trie* tree = new Trie();
    int ans = 0, temp = 0;
    bool flag = true, ret = false;
    vector<string> word_list;
    string word = "";

    while(flag)
    {
        cout<<"--------------------------------------------";
        cout<<"\nEnter from following menu:";
        cout<<"\n1). Insert word";
        cout<<"\n2). Search word";
        cout<<"\n3). Get Trie size";
        cout<<"\n4). Delete word";
        cout<<"\n5). Print all words starting with a prefix";
        cout<<"\n6). Exit";
        cout<<"\nEnter:";
        cin>>ans;

        switch(ans)
        {
            case 1:
                cout<<"\nEnter the word:";
                cin>>word;
                tree->insert(word);
                cout<<"\nWord inserted successfully!\n\n";
                break;
            
            case 2:
                cout<<"\nEnter the word:";
                cin>>word;
                ret = tree->search(word);

                if(ret == true)
                {
                    cout<<"\nWord found in the Trie!\n\n";
                }
                else
                {
                    cout<<"\nWord not found in the Trie.\n\n";
                }
                break;
            
            case 3:
                cout<<"\nTrie size: "<<tree->get_trie_size()<<" characters\n\n";
                break;
            
            case 4:
                cout<<"\nEnter the word:";
                cin>>word;
                temp = tree->delete_word(word);

                if(temp == -1)
                {
                    cout<<"\nWord not found in the Trie.\n\n";
                }
                else
                {
                    cout<<"\nWord successfully deleted!\n\n";
                }
                break;

            case 5:
                cout<<"\nEnter the prefix:";
                cin>>word;
                word_list = tree->startsWith(word);

                if(word_list.size() == 0)
                {
                    cout<<"\nNo word in the Trie starts with "<<word<<"\n\n";
                }
                else
                {
                    cout<<"\nFollowing words in the Trie starts with "<<word<<":\n";
                    for(int i=0;i<word_list.size();i++)
                    {
                        cout<<"\n"<<word_list[i];
                    }
                    cout<<"\n\n";
                }
                break;

            default:
                flag = false;
                break;
        }
    }
    return 0;
}