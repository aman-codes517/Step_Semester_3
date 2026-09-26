public class Parking_Allocation {

    static class ParkingSlot {

        String slotNo;
        int capacity;
        int occupiedCount;

        ParkingSlot(
            String slotNo,
            int capacity,
            int occupiedCount
        ) {
            this.slotNo = slotNo;
            this.capacity = capacity;
            this.occupiedCount = occupiedCount;
        }

        void allot(String vehicleNo) {

            if (occupiedCount < capacity) {

                occupiedCount++;

                System.out.println(
                    vehicleNo +
                    " allotted to slot " +
                    slotNo
                );
            }
        }
    }

    static ParkingSlot findAvailableSlot(
        ParkingSlot[] slots
    ) {

        for (ParkingSlot slot : slots) {

            if (slot.occupiedCount < slot.capacity) {
                return slot;
            }
        }

        return null;
    }

    static void safeAllot(
        ParkingSlot[] slots,
        String vehicleNo
    ) {

        ParkingSlot slot =
            findAvailableSlot(slots);

        if (slot == null) {

            System.out.println(
                "No slots available for " +
                vehicleNo
            );

        } else {

            slot.allot(vehicleNo);
        }
    }

    public static void main(String[] args) {

        /*
         * Passing a ParkingSlot[] does not copy the ParkingSlot
         * objects. The array contains references to the same objects.
         */

        ParkingSlot[] slots1 = {

            new ParkingSlot("A1", 4, 3),
            new ParkingSlot("A2", 5, 5)
        };

        System.out.println(
            "Slots: A1 (3/4), A2 (5/5)"
        );

        safeAllot(
            slots1,
            "TN09AB1234"
        );


        ParkingSlot[] slots2 = {

            new ParkingSlot("A1", 4, 4),
            new ParkingSlot("A2", 5, 5)
        };

        System.out.println(
            "Slots: A1 (4/4), A2 (5/5)"
        );

        safeAllot(
            slots2,
            "TN09AB1234"
        );
    }
}