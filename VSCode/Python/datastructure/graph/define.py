from collections import deque
from check import person_is_seller
graph = {}
graph["you"] = ["alice", "bob", "claire"] 
graph["bob"] = ["anuj", "peggy"] 
graph["alice"] = ["peggy"] 
graph["claire"] = ["thom", "jonny"] 
graph["anuj"] = [] 
graph["peggy"] = [] 
graph["thom"] = [] 
graph["jonny"] = [] 

search_deque = deque()
search_deque += graph["you"]

while(search_deque):         
    person = search_deque.popleft()
    if person_is_seller(person):
        print(person)
    else:
        search_deque += graph[person]

