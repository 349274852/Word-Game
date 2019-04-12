1.
Stanley Chan
Kelvin Mo
Yameen Abba
Steven Lin
2.
In our project we used arraylists, hashmaps, and queues. These data structures are mostly found in the following classes:
MyWorld
Scores
A majority of the other classes utilize the arraylists, hashmaps, and queues created in these classes.
3.
I feel that the typing mechanic was pretty creative in terms of how it works, as it searches through a hashmap, checks if there is a word value that exists
in the key containing the letter that they pressed, then acting accordingly. Additionally, I felt as if the word spawning mechanic was also creative, as
it would only spawn the word in the world so long as another word with the same first letter as it didn't already exist in the world. 
One thing that took us a while to figure out was how to sort all of the high scores into ascending order. We were originally going to use hashmaps,
but we found it most effective to use an arraylist that stores a bunch of playerscore objects, each having their own name and score. This method was
considerably less confusing than using hashmaps. Speaking about scores, the entire score system was pretty much the final ordeal for our project as
we couldn't quite figure out how to transfer the scores and save them throughout all the worlds and not have them reset whenever the player switched
worlds. We eventually figured this out by making the scores object a general object and not extend actor. Then we made the scores arraylist static so we
could use it across different classes. 
4. 
We were originally going to have different music playing for each menu screen, but each music file was incredibly large, so changing back and forth from
song to song as the player navigated through the menus took up noticeably lots of memory, and as such as ran into multiple java heap memory space errors.
Also, we were also planning on having multiple different power ups, such as the ability to shoot faster lasers, having the enemies slow down, etc. but
the first powerup took us so long to figure out that we just decided to stick with one due to time constraints. Furthermore, we were also planning on
giving the player 3 lives, but also due to lack of time we were not able to implement this feature.

 