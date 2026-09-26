public class F5_Fee_Hostel_Management {

    // =========================================
    // FEE ACCOUNT
    // =========================================

    static class FeeAccount {

        private String regNo;
        private double totalFee;
        private double amountPaid;

        FeeAccount(
            String regNo,
            double totalFee,
            double amountPaid
        ) {
            this.regNo = regNo;
            this.totalFee = totalFee;
            this.amountPaid = amountPaid;
        }

        void pay(double amount) {

            // Reject negative or zero payment
            if (amount <= 0) {

                System.out.println(
                    "Payment rejected for " + regNo
                );

                return;
            }

            double due = getDue();

            if (amount > due) {
                amountPaid += due;
            } else {
                amountPaid += amount;
            }
        }

        double getDue() {
            return totalFee - amountPaid;
        }
    }


    // =========================================
    // HOSTEL FEE ACCOUNT
    // =========================================

    static class HostelFeeAccount
        extends FeeAccount {

        HostelFeeAccount(
            String regNo,
            double totalFee,
            double amountPaid
        ) {
            super(regNo, totalFee, amountPaid);
        }

        void payInTwoInstallments(double amount) {

            pay(amount);
            pay(amount);
        }
    }


    // =========================================
    // HOSTEL ROOM
    // =========================================

    static class HostelRoom {

        String roomNo;
        int beds;
        int occupied;

        HostelRoom(
            String roomNo,
            int beds,
            int occupied
        ) {
            this.roomNo = roomNo;
            this.beds = beds;
            this.occupied = occupied;
        }

        void allot(String name) {

            if (occupied < beds) {

                occupied++;

                System.out.println(
                    name +
                    " allotted to room " +
                    roomNo
                );
            }
        }
    }


    // =========================================
    // FIND AVAILABLE ROOM
    // =========================================

    static HostelRoom findAvailableRoom(
        HostelRoom[] rooms
    ) {

        for (HostelRoom room : rooms) {

            if (room.occupied < room.beds) {
                return room;
            }
        }

        return null;
    }


    // =========================================
    // SAFE ALLOT
    // =========================================

    static HostelRoom safeAllot(
        HostelRoom[] rooms,
        String studentName
    ) {

        HostelRoom room =
            findAvailableRoom(rooms);

        if (room == null) {

            System.out.println(
                "No rooms available for " +
                studentName
            );

            return null;
        }

        room.allot(studentName);

        return room;
    }


    // =========================================
    // SRM STUDENT
    // =========================================

    static class SrmStudent {

        String name;
        String regNo;

        // Object inside another object = composition
        HostelFeeAccount feeAccount;

        HostelRoom room;

        static int totalStudents = 0;

        SrmStudent(
            String name,
            String regNo,
            HostelFeeAccount feeAccount
        ) {

            this.name = name;
            this.regNo = regNo;
            this.feeAccount = feeAccount;

            totalStudents++;
        }

        String fullStatus() {

            String roomNumber;

            if (room == null) {

                roomNumber = "unallotted";

            } else {

                roomNumber = room.roomNo;
            }

            return name +
                " | Due: Rs " +
                feeAccount.getDue() +
                " | Room: " +
                roomNumber;
        }
    }


    // =========================================
    // MAIN
    // =========================================

    public static void main(String[] args) {

        // =========================================
        // CREATE ROOMS
        // =========================================

        HostelRoom[] rooms = {

            new HostelRoom("C-214", 1, 0),

            new HostelRoom("C-507", 1, 0)
        };


        // =========================================
        // CREATE STUDENTS
        // =========================================

        SrmStudent ravi =
            new SrmStudent(
                "Ravi",
                "RA231100301011",
                new HostelFeeAccount(
                    "RA231100301011",
                    200000,
                    0
                )
            );

        SrmStudent anitha =
            new SrmStudent(
                "Anitha",
                "RA231100301012",
                new HostelFeeAccount(
                    "RA231100301012",
                    180000,
                    0
                )
            );

        SrmStudent karthik =
            new SrmStudent(
                "Karthik",
                "RA231100301013",
                new HostelFeeAccount(
                    "RA231100301013",
                    200000,
                    0
                )
            );


        // =========================================
        // ALLOT ROOMS TO ONLY TWO STUDENTS
        // =========================================

        ravi.room =
            safeAllot(
                rooms,
                "Ravi"
            );

        anitha.room =
            safeAllot(
                rooms,
                "Anitha"
            );

        // Karthik intentionally remains unallotted
        karthik.room = null;


        // =========================================
        // PAYMENTS
        // =========================================

        // Valid payment
        ravi.feeAccount.pay(60000);

        // Invalid negative payment
        anitha.feeAccount.pay(-5000);

        // No payment for Karthik


        // =========================================
        // DISPLAY STATUS
        // =========================================

        System.out.println(
            ravi.fullStatus()
        );

        System.out.println(
            anitha.fullStatus()
        );

        System.out.println(
            karthik.fullStatus()
        );


        // =========================================
        // TOTAL STUDENTS
        // =========================================

        System.out.println(
            "Total students: " +
            SrmStudent.totalStudents
        );
    }
}