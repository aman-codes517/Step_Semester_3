public class F1_Attendance_System {

    static class SrmStudent {

        String name;
        String regNo;
        int attendance;

        // Constructor
        SrmStudent(String name, String regNo, int attendance) {
            this.name = name;
            this.regNo = regNo;
            this.attendance = attendance;
        }

        // Updates the attendance of this particular student
        void addAttendanceUpdate(int newAttendance) {
            attendance = newAttendance;
        }

        // Checks this particular student's attendance
        boolean isEligible() {
            return attendance >= 75;
        }

        /*
         * classAverage() is static because it works on the whole
         * array of students, not on one particular student.
         *
         * isEligible() is not static because it checks the
         * attendance of one particular student object.
         */
        static double classAverage(SrmStudent[] students) {

            int total = 0;

            for (SrmStudent student : students) {
                total += student.attendance;
            }

            return (double) total / students.length;
        }
    }

    public static void main(String[] args) {

        SrmStudent[] students = new SrmStudent[5];

        students[0] =
            new SrmStudent("Ravi", "RA231100301011", 82);

        students[1] =
            new SrmStudent("Anitha", "RA231100301012", 68);

        students[2] =
            new SrmStudent("Karthik", "RA231100301013", 91);

        students[3] =
            new SrmStudent("Meera", "RA231100301014", 74);

        students[4] =
            new SrmStudent("Suresh", "RA231100301015", 60);

        for (SrmStudent student : students) {

            if (student.isEligible()) {

                System.out.println(
                    student.name + " - " +
                    student.attendance + "% - Eligible"
                );

            } else {

                System.out.println(
                    student.name + " - " +
                    student.attendance + "% - Detained"
                );
            }
        }

        double average =
            SrmStudent.classAverage(students);

        System.out.println(
            "Class average: " + average + "%"
        );
    }
}