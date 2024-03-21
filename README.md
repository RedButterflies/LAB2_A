1_2:
Write an application with an interface similar to the one shown in figure 1.16. The program should meet the following conditions:

It should allow entering the first name, last name, and the number of student grades.
Text fields should have hints.
Data correctness must be checked, i.e., the first name and last name fields cannot be empty, and the number of grades must belong to the range [5;15].
Upon leaving a field (losing focus) containing an invalid value, a message should be displayed (Toast with appropriate information). Additionally, an error message should be set in text fields.
The Grades button should only appear when all fields contain valid values.
Linear layouts (vertical and horizontal) should be used for arranging elements. The application should support both orientations. After rotating the device, the view elements should be correctly laid out.



Modify the program from Exercise 1.2 as follows:

Use only one layout with constraints instead of nested linear layouts (the appearance of the application should be identical).
Preserve and restore the activity state upon device rotation (pay attention to text fields, button visibility, error state in text fields - which of them need to be preserved/restored independently?).
All texts displayed in the application should be defined in the strings.xml file.
