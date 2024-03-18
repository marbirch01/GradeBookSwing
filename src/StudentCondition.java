public enum  StudentCondition{

    Odrabiajacy{
        @Override
        public String toString() {
            return "Odrabiający";
        }
    },
    Chory{
        @Override
        public String toString() {
            return "Chory";
        }
    },
    Nieobecny{
        @Override
        public String toString() {
            return "Nieobecny";
        }
    },

}