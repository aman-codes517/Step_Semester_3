public class Library_Fine_System {

    static class BookIssue {

        String title;
        String borrowerName;
        int daysOverdue;

        BookIssue(String title, String borrowerName, int daysOverdue) {
            this.title = title;
            this.borrowerName = borrowerName;
            this.daysOverdue = daysOverdue;
        }

        double fineAmount() {
            if (daysOverdue > 0) {
                return daysOverdue * 5;
            }
            return 0;
        }

        boolean isSeverelyOverdue() {
            return daysOverdue > 14;
        }

        // Static because this calculates the total for many BookIssue
        // objects, not for one particular BookIssue object.
        static double totalFineCollected(BookIssue[] issues) {

            double total = 0;

            for (BookIssue issue : issues) {
                total += issue.fineAmount();
            }

            return total;
        }
    }

    public static void main(String[] args) {

        BookIssue[] issues = new BookIssue[5];

        issues[0] = new BookIssue("Clean Code", "Aman", 18);
        issues[1] = new BookIssue("Effective Java", "Rahul", 5);
        issues[2] = new BookIssue("Refactoring", "Karan", 0);
        issues[3] = new BookIssue("DSA Handbook", "Riya", 21);
        issues[4] = new BookIssue("Design Patterns", "Neha", 9);

        for (BookIssue issue : issues) {

            if (issue.isSeverelyOverdue()) {
                System.out.println(
                    issue.title + " - " +
                    issue.daysOverdue +
                    " days - Severely overdue"
                );
            } else {
                System.out.println(
                    issue.title + " - " +
                    issue.daysOverdue +
                    " days - OK"
                );
            }
        }

        double total = BookIssue.totalFineCollected(issues);

        System.out.println(
            "Total fine collected: Rs " + total
        );
    }
}