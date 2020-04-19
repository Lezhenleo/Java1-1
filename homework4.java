package ru.homework.lesson4;


    class Person {
        private String FIO;
        private String Post;
        private String Email;
        private String Tel;
        private double Salary;
        private int Age;

        Person(String FIO, String Post, String Email, String Tel, double Salary, int Age) {
            this.FIO = FIO;
            this.Post = Post;
            this.Email = Email;
            this.Tel = Tel;
            this.Salary = Salary;
            if(Age >= 18) {
                this.Age = Age;
            } else {
                System.out.println("Сотрудник должен быть старше 18 лет");
            }
        }

        int GetAge() {
            return Age;
        }

        void Show() {
            System.out.println(FIO + " " + Post + " " +  Email + " " + Tel + " " + Salary + " " + Age);
        }
    }



    class Main {

        public static void main(String[] args) {

            Person[] persArray = new Person[5];
            persArray[0] = new Person("Petrii Sergey",  "Engineer",  "petro@mail.ru",  "8923582567", 25000, 25);
            persArray[1] = new Person("Petrov Ivan", "Engineer1", "petrov@yandex.ru", "8905356399", 32000, 35);
            persArray[2] = new Person("Petrov Andrey", "Engineer2", "pertra@list.ru", "8918388921", 37000, 42);
            persArray[3] = new Person("Ivanov Petr", "Engineer3", "ivanov@rambler.ru", "8918228713", 42000, 58);
            persArray[4] = new Person("Sidorov Ivan", "Engineer4", "sidorov@gmail.com", "8903340788", 50000, 64);

            for(Person item : persArray) {
                if(item.GetAge() > 40) item.Show();
            }
        }
    }

