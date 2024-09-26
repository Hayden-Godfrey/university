public class Person
{
    private String name;
    public Person(String initialName)
    {
        name = initialName;
    }

    // mutator and accessor methods for name
    public void setName(String newName)
    {
        name = newName;
    }
    public String getName()
    {
        return name;
    }

    // prints name to stdout
    public void writeOutput() {
        System.out.println("Name: " + name);
    }

    // method to determine if two Persons are the same based on their names
    public boolean equals(Person otherPerson) {
        return this.getName().equalsIgnoreCase(otherPerson.getName()); }
}