public class F4_SrmStudent_Static {

    // =========================================
    // BROKEN VERSION
    // =========================================

    static class BrokenSrmStudent {

        static String name;
        static String regNo;
        static int attendance;

        BrokenSrmStudent(
            String name,
            String regNo,
            int attendance
        ) {

            BrokenSrmStudent.name = name;
            BrokenSrmStudent.regNo = regNo;
            BrokenSrmStudent.attendance = attendance;
        }
    }


    // =========================================
    // FIXED VERSION
    // =========================================

    static class SrmStudent {

        // Instance fields
        String name;
        String regNo;
        int attendance;

        // Static fields
        static String university = "SRMIST";
        static int admissionCount = 0;

        SrmStudent(
            String name,
            int attendance
        ) {

            this.name = name;
            this.attendance = attendance;

            admissionCount++;

            this.regNo =
                "RA2311003010" +
                String.format("%02d", admissionCount);
        }

        void printIdCard() {

            System.out.println(
                name + " | " + regNo
            );
        }

        static void printTotalAdmissions() {

            System.out.println(
                "Students admitted so far: " +
                admissionCount
            );
        }
    }


    public static void main(String[] args) {

        // =========================================
        // BROKEN VERSION
        // =========================================

        System.out.println("Broken version:");

        BrokenSrmStudent ravi =
            new BrokenSrmStudent(
                "Ravi",
                "RA001",
                82
            );

        BrokenSrmStudent meera =
            new BrokenSrmStudent(
                "Meera",
                "RA002",
                74
            );

        System.out.println(ravi.name);
        System.out.println(meera.name);

        /*
         * Why static is wrong:
         *
         * name is static -> shared by every student.
         * regNo is static -> shared by every student.
         * attendance is static -> shared by every student.
         *
         * Therefore, when Meera is created, her values
         * overwrite Ravi's values.
         */


        // =========================================
        // FIXED VERSION
        // =========================================

        System.out.println();
        System.out.println(
            "Fixed version: same two students created"
        );

        SrmStudent student1 =
            new SrmStudent(
                "Ravi",
                82
            );

        SrmStudent student2 =
            new SrmStudent(
                "Meera",
                74
            );

        student1.printIdCard();

        student2.printIdCard();

        SrmStudent.printTotalAdmissions();
    }
}