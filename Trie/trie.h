#ifndef __TRIE__H__
#define __TRIE__H__
#include "dictionary.h"

class Trie
{   
    private:
        int size;
        char c_value;
        bool word_end;              // Stores whether current node is the end of any word
        dict<char, class Trie*> v;  // Stores children

        // Search for given prefix and returns last Trie node corresponding to prefix if it exists.
        Trie* searchPrefix(std::string prefix)
        {
            if(prefix.length()>0)
            {
                char c = prefix[0];
                if(v.exists(c))
                {
                    if(prefix.length()-1 == 0)
                    {
                        return v[c];
                    }
                    else
                    {
                        return v[c]->searchPrefix(prefix.substr(1));
                    }
                }
            }
            return NULL;
        }

        // Traverses the Trie
        void TraverseGraph(Trie* node, std::string prefix, std::vector<std::string>& words)
        {
            std::string f_prefix = prefix + node->c_value;
            std::vector<char> keys = node->v.keys();

            if(node->word_end == true)
            {
                words.push_back(f_prefix);
            }

            for(int i=0;i<keys.size();i++)
            {
                TraverseGraph(node->v[keys[i]], f_prefix, words);
            }
        }

    public:
        Trie()
        {
            size = 1;
            c_value = '\0';
            word_end = false;
        }

        Trie(char c)
        {
            size = 1;
            c_value = c;
            word_end = false;
        }
        
        // Inserts a word into the trie.
        int insert(std::string word)
        {
            int size_counter = 0;

            if (word.length()>0)
            {
                char c = word[0];
                
                if(!v.exists(c))
                {
                    v[c] = new Trie(c);
                    size_counter++; 
                }
                
                size_counter += v[c]->insert(word.substr(1));
            }
            else
            {
                word_end = true;
            }
            size += size_counter;
            return size_counter;
        }

        // Return Trie size
        int get_trie_size()
        {
            return size;
        }

        // Returns if the word is in the trie.
        Trie* search(std::string word)
        {
            if(word.length()>0)
            {
                char c = word[0];
                if(v.exists(c))
                {
                    if(word.length()-1 == 0 && v[c]->word_end)
                    {
                        return v[c];
                    }
                    else
                    {
                        return v[c]->search(word.substr(1));
                    }
                }
            }
            return NULL;
        }

        // Deletes the word from the Trie
        int delete_word(std::string word)
        {
            if(word.length()>0)
            {
                char c = word[0];
                if(v.exists(c))
                {
                    if(word.length()-1 == 0 && v[c]->word_end)
                    {
                        if(v[c]->v.empty())
                        {
                            delete v[c];
                            v.erase(c);
                            size--;
                            return 1;
                        }
                        else
                        {
                            v[c]->word_end = false;
                            return 0;
                        }
                    }
                    else
                    {
                        int retval;
                        retval = v[c]->delete_word(word.substr(1));

                        if(retval == -1)
                        {
                            return -1;
                        }
                        else
                        {
                            if(v[c]->v.empty() && !v[c]->word_end)
                            {
                                delete v[c];
                                v.erase(c);
                                retval++;
                            }
                            size -= retval;
                            return retval;
                        }
                    }
                }
            }
            return -1;
        }

        // Returns words starting with given prefix
        std::vector<std::string> startsWith(std::string prefix)
        {
            std::vector<std::string> prefix_words;
            Trie* node = searchPrefix(prefix);

            if(node != NULL)
            {
                TraverseGraph(node, prefix.substr(0, prefix.length()-1), prefix_words);
            }
            return prefix_words;
        }
};
#endif // __TRIE__H__