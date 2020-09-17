class Employee
{  
    int id;  
    String name;  

    Employee(int i,String s)
    {  
        id = i;  
        name = s;  
    }  

    void display()
    {
        System.out.println(id+" - "+name);
    }  

    public static void main(String args[])
    {  
        Employee e = new Employee(3022,"Anujay");   
        e.display();    
    }  
}  