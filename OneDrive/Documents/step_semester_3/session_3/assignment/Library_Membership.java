public class Library_Membership {

    // ==============================
    // BROKEN VERSION
    // ==============================

    static class BrokenLibraryMember {

        static String name;
        static String memberId;
        static int booksIssued;

        BrokenLibraryMember(
            String name,
            String memberId,
            int booksIssued
        ) {

            BrokenLibraryMember.name = name;
            BrokenLibraryMember.memberId = memberId;
            BrokenLibraryMember.booksIssued = booksIssued;
        }
    }


    // ==============================
    // FIXED VERSION
    // ==============================

    static class LibraryMember {

        // Instance fields
        String name;
        String memberId;
        int booksIssued;

        // Static fields
        static String libraryName = "Central Library";
        static int memberCount = 0;

        LibraryMember(
            String name,
            int booksIssued
        ) {

            this.name = name;
            this.booksIssued = booksIssued;

            memberCount++;

            this.memberId =
                "LM-" + (1000 + memberCount);
        }

        void printMemberCard() {

            System.out.println(
                name + " | " + memberId
            );
        }

        static void printTotalMembers() {

            System.out.println(
                "Total members: " +
                memberCount
            );
        }
    }


    public static void main(String[] args) {

        // ==============================
        // BROKEN VERSION
        // ==============================

        System.out.println("Broken version:");

        BrokenLibraryMember member1 =
            new BrokenLibraryMember(
                "Aditi",
                "LM-1001",
                2
            );

        BrokenLibraryMember member2 =
            new BrokenLibraryMember(
                "Rohan",
                "LM-1002",
                3
            );

        System.out.println(member1.name);
        System.out.println(member2.name);

        /*
         * name is static, so it is shared by all objects.
         *
         * memberId is static, so it is also shared.
         *
         * booksIssued is static, so it is shared too.
         *
         * Therefore, creating Rohan overwrites Aditi's data.
         */


        // ==============================
        // FIXED VERSION
        // ==============================

        System.out.println();
        System.out.println("Fixed version:");

        LibraryMember aditi =
            new LibraryMember(
                "Aditi",
                2
            );

        LibraryMember rohan =
            new LibraryMember(
                "Rohan",
                3
            );

        aditi.printMemberCard();

        rohan.printMemberCard();

        LibraryMember.printTotalMembers();
    }
}