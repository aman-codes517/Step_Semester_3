public class F2_Fee_Account {

    // =========================================
    // PARENT CLASS
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

        // Pay method
        void pay(double amount) {

            // Reject non-positive payment
            if (amount <= 0) {
                System.out.println(
                    "Payment rejected for " + regNo
                );
                return;
            }

            // Don't allow payment greater than remaining due
            double due = getDue();

            if (amount > due) {
                amountPaid += due;
            } else {
                amountPaid += amount;
            }
        }

        // Calculate remaining fee
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

            // Pay the first installment
            pay(amount);

            // Pay the second installment
            pay(amount);
        }
    }


    // =========================================
    // SCHOLARSHIP FEE ACCOUNT
    // =========================================

    static class ScholarshipFeeAccount
        extends FeeAccount {

        private double scholarshipPercent;

        ScholarshipFeeAccount(
            String regNo,
            double totalFee,
            double amountPaid,
            double scholarshipPercent
        ) {
            super(regNo, totalFee, amountPaid);

            this.scholarshipPercent = scholarshipPercent;
        }

        double effectiveDue() {

            double due = getDue();

            double discount =
                due * scholarshipPercent / 100;

            return due - discount;
        }
    }


    // =========================================
    // MAIN
    // =========================================

    public static void main(String[] args) {

        // Plain account
        FeeAccount plain =
            new FeeAccount(
                "RA001",
                150000,
                0
            );

        // Pay full amount
        plain.pay(150000);


        // Hostel account
        HostelFeeAccount hostel =
            new HostelFeeAccount(
                "RA002",
                200000,
                0
            );

        // Two payments of 30000 = 60000 paid
        hostel.payInTwoInstallments(30000);


        // Scholarship account
        ScholarshipFeeAccount scholarship =
            new ScholarshipFeeAccount(
                "RA003",
                180000,
                0,
                20
            );


        // Store all accounts in parent-type array
        FeeAccount[] accounts = {
            plain,
            hostel,
            scholarship
        };


        for (FeeAccount account : accounts) {

            if (account instanceof ScholarshipFeeAccount) {

                ScholarshipFeeAccount s =
                    (ScholarshipFeeAccount) account;

                System.out.println(
                    "Scholarship account effective due: Rs " +
                    s.effectiveDue()
                );

            } else if (account instanceof HostelFeeAccount) {

                HostelFeeAccount h =
                    (HostelFeeAccount) account;

                System.out.println(
                    "Hostel account due: Rs " +
                    h.getDue()
                );

            } else {

                System.out.println(
                    "Plain account due: Rs " +
                    account.getDue()
                );
            }
        }
    }
}