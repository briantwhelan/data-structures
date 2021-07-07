# Data-Structures
## ArrayList
### Overview and Basic API
An ArrayList is essentially an array which has no fixed capacity. In Java, if an array becomes full, you cannot add more elements to that array. Instead, a larger array must be created and all of the elements (including the new element) must be copied to this larger array. Obviously this is not very efficient, especially when the array size is known to be needed to change throughout the lifetime of a program. 

An ArrayList enables elements to be added and removed freely without needing to worry about the actual ArrayList size.

### Basic API Space and Time Complexity
An ArrayList has three main operations that are allowed: add, remove and get.
| Method            | Time Complexity | Space Complexity |
|-------------------|-----------------|------------------|
| add(T element)    | O(1)            | O(1)             |
| remove(int index) | O(1)            | O(1)             |
| get(int index)    | O(1)            | O(1)             |

### Potential Improvements


### Uses and Final Thoughts

