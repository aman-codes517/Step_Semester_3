public class HR_Parking_Mini_System {

    // =================================
    // EMPLOYEE
    // =================================

    static class Employee {

        private int empId;
        private String empName;
        private double salary;

        Employee(
            int empId,
            String empName,
            double salary
        ) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
        }

        double getSalary() {
            return salary;
        }
    }


    // =================================
    // MANAGER
    // =================================

    static class ManagerEmployee
        extends Employee {

        private double teamBonus;

        ManagerEmployee(
            int empId,
            String empName,
            double salary,
            double teamBonus
        ) {
            super(empId, empName, salary);

            this.teamBonus = teamBonus;
        }

        double effectiveSalary() {

            return getSalary() + teamBonus;
        }
    }


    // =================================
    // INTERN
    // =================================

    static class InternEmployee
        extends Employee {

        private double stipendCap;

        InternEmployee(
            int empId,
            String empName,
            double salary,
            double stipendCap
        ) {
            super(empId, empName, salary);

            this.stipendCap = stipendCap;
        }

        double effectiveSalary() {

            if (getSalary() < stipendCap) {
                return getSalary();
            }

            return stipendCap;
        }
    }


    // =================================
    // PARKING SLOT
    // =================================

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
            }
        }
    }


    // =================================
    // FIND AVAILABLE SLOT
    // =================================

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


    // =================================
    // SAFE ALLOTMENT
    // =================================

    static ParkingSlot safeAllot(
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

            return null;
        }

        slot.allot(vehicleNo);

        return slot;
    }


    // =================================
    // COMPANY EMPLOYEE RECORD
    // =================================

    static class CompanyEmployeeRecord {

        String name;
        String empId;

        Employee employee;

        ParkingSlot slot;

        static int totalRecords = 0;

        CompanyEmployeeRecord(
            String name,
            String empId,
            Employee employee,
            ParkingSlot slot
        ) {

            this.name = name;
            this.empId = empId;
            this.employee = employee;
            this.slot = slot;

            totalRecords++;
        }

        String fullProfile() {

            double pay;

            if (employee instanceof ManagerEmployee) {

                ManagerEmployee manager =
                    (ManagerEmployee) employee;

                pay = manager.effectiveSalary();

            } else if (
                employee instanceof InternEmployee
            ) {

                InternEmployee intern =
                    (InternEmployee) employee;

                pay = intern.effectiveSalary();

            } else {

                pay = employee.getSalary();
            }


            String slotInfo;

            if (slot == null) {

                slotInfo = "no parking assigned";

            } else {

                slotInfo = slot.slotNo;
            }


            return name +
                " | Pay: Rs " +
                pay +
                " | Slot: " +
                slotInfo;
        }
    }


    // =================================
    // MAIN
    // =================================

    public static void main(String[] args) {

        // Parking slots
        ParkingSlot slotA1 =
            new ParkingSlot("A1", 1, 0);

        ParkingSlot slotA2 =
            new ParkingSlot("A2", 1, 0);

        ParkingSlot[] parkingSlots = {
            slotA1,
            slotA2
        };


        // Employees
        Employee divya =
            new ManagerEmployee(
                101,
                "Divya",
                70000,
                8000
            );

        Employee karan =
            new Employee(
                102,
                "Karan",
                40000
            );

        Employee meera =
            new InternEmployee(
                103,
                "Meera",
                12000,
                10000
            );


        // Give parking to Divya
        ParkingSlot divyaSlot =
            safeAllot(
                parkingSlots,
                "TN01DIVYA"
            );


        // Give parking to Karan
        ParkingSlot karanSlot =
            safeAllot(
                parkingSlots,
                "TN01KARAN"
            );


        // Meera intentionally has no parking
        ParkingSlot meeraSlot = null;


        // Create records
        CompanyEmployeeRecord record1 =
            new CompanyEmployeeRecord(
                "Divya",
                "101",
                divya,
                divyaSlot
            );

        CompanyEmployeeRecord record2 =
            new CompanyEmployeeRecord(
                "Karan",
                "102",
                karan,
                karanSlot
            );

        CompanyEmployeeRecord record3 =
            new CompanyEmployeeRecord(
                "Meera",
                "103",
                meera,
                meeraSlot
            );


        // Display profiles
        System.out.println(
            record1.fullProfile()
        );

        System.out.println(
            record2.fullProfile()
        );

        System.out.println(
            record3.fullProfile()
        );


        // Display total records
        System.out.println(
            "Total records: " +
            CompanyEmployeeRecord.totalRecords
        );
    }
}