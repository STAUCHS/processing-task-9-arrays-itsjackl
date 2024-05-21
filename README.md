# Processing Task 9 - Arrays

## Learning Objectives
In this task, you will learn about defining arrays to animate a collection of objects.


## Step 1 - Lesson
Acquire the learning objectives by reviewing [this page in happycoding.io](https://happycoding.io/tutorials/processing/arrays)

## Step 2 - Task
Demonstrate your learning objectives by implementing the following:
  
### Level 2
Create a sketch that simulates snow falling. NOTE: In the tutorial, they set the x-values in terms of the randomly generated y values. INSTEAD, what you are going to do is:
1. Create an array of randomly generated y-values for the snowflakes. These y-values should cause the snowflakes to *start off screen* and fall into the screen
2. Create a **related array** of randomly generated x-values for the snowflakes (This is different from the tutorial)

In addition,

3. When the down arrow is pressed on the keyboard, the snow falls faster.
4. Likewise, the snow falls slower when the up arrow is pressed. 
  
### Level 3
Extend your snowfall progam by:
1. Adding a blue player circle (or an image if you'd like) that is controlled by the user with the WASD keys. 
2. Add a three squares at the top right of the screen to indicate player lives. The player loses a life everytime it collides with a snowflake. 
3. The game ends when all lives are lost and the screen clears to white.
  
### Level 4
Extend the Level 3 program with:
1. Mouse control such that while the player is controlled with the left hand (with keyboard), the mouse can be used to click on snowflakes and make them disappear if they are clicked on. You may need to make the snowflakes bigger so they are easier to click on.

**HINT:** You will need to declare a `ballHideStatus` related array that stores the state of each snowball. The elements of this array will be defaulted to `false`. When a snowball is clicked on, the snowball's corresponding `ballHideStatus` will be set to `true` and the snowball will no longer be drawn to the screen.

<span style="color:red">
<b>NOTE: It would be a good idea to make use of <ins>methods</ins> here.</b>
</span>

## Submission
1. Commit and push your code to this repository
2. Take a screen recording of your work and upload it to the Google Classroom assignment post.

**Make sure to:**
- Javadoc comment all methods
- Apply appropriate style and variable naming conventions.
