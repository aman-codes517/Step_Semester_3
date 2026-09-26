public class F3_Hostel_Room {

    // =========================================
    // HOSTEL ROOM CLASS
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

        // Allot one bed
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

    static void safeAllot(
        HostelRoom[] rooms,
        String studentName
    ) {

        HostelRoom room =
            findAvailableRoom(rooms);

        /*
         * findAvailableRoom() may return null.
         *
         * We check for null before calling allot().
         * Therefore, there is no NullPointerException.
         */
        if (room == null) {

            System.out.println(
                "No rooms available for " +
                studentName
            );

        } else {

            room.allot(studentName);
        }
    }


    public static void main(String[] args) {

        /*
         * An array of HostelRoom contains references
         * to HostelRoom objects. Passing the array to a
         * method passes those references, not copies of
         * the actual room objects.
         */

        // =========================================
        // CASE 1: ROOM AVAILABLE
        // =========================================

        HostelRoom[] rooms1 = {

            new HostelRoom("C-214", 3, 2),

            new HostelRoom("C-507", 2, 2)
        };

        System.out.println(
            "Rooms: C-214 (2/3), C-507 (2/2)"
        );

        safeAllot(
            rooms1,
            "Divya"
        );


        // =========================================
        // CASE 2: ALL ROOMS FULL
        // =========================================

        HostelRoom[] rooms2 = {

            new HostelRoom("C-214", 3, 3),

            new HostelRoom("C-507", 2, 2)
        };

        System.out.println(
            "Rooms: C-214 (3/3), C-507 (2/2)"
        );

        safeAllot(
            rooms2,
            "Divya"
        );
    }
}