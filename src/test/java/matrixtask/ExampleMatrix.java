package matrixtask;

import matrixtask.matrixoperations.Matrix;


    public enum ExampleMatrix {
        SIZE_2X3_ALL_2(Matrix.crate(new double[][]{
                {2.0, 2.0, 2.0},
                {2.0, 2.0, 2.0},

        })),
        SIZE_3X2_ALL_2(Matrix.crate(new double[][]{
                {2.0, 2.0},
                {2.0, 2.0},
                {2.0, 2.0}

        })),
        SIZE_3X3_ALL_1(Matrix.crate(new double[][]{
                {1.0, 1.0, 1.0},
                {1.0, 1.0, 1.0},
                {1.0, 1.0, 1.0},
        })),
        SIZE_3X3_ALL_3(Matrix.crate(new double[][]{
                {3.0, 3.0, 3.0},
                {3.0, 3.0, 3.0},
                {3.0, 3.0, 3.0},

        })),
        SIZE_3X3_ALL_4(Matrix.crate(new double[][]{
                {4.0, 4.0, 4.0},
                {4.0, 4.0, 4.0},
                {4.0, 4.0, 4.0},

        })),
        SIZE_4X3_ALL_NEGATIV_1(Matrix.crate(new double[][]{
                {-1.0, -1.0, -1.0},
                {-1.0, -1.0, -1.0},
                {-1.0, -1.0, -1.0},
                {-1.0, -1.0, -1.0}
        })),
        SIZE_3X3_ALL_8(Matrix.crate(new double[][]{
                {8.0, 8.0, 8.0},
                {8.0, 8.0, 8.0},
                {8.0, 8.0, 8.0}
        })),
        SIZE_4X3_ALL_5(Matrix.crate(new double[][]{
                {5.0, 5.0, 5.0},
                {5.0, 5.0, 5.0},
                {5.0, 5.0, 5.0},
                {5.0, 5.0, 5.0}
        })),
        SIZE_3X4_ALL_4(Matrix.crate(new double[][]{
                {4.0, 4.0, 4.0,4.0},
                {4.0, 4.0, 4.0,4.0},
                {4.0, 4.0, 4.0,4.0}
        }));





        private Matrix matrix;

        ExampleMatrix(Matrix matrix) {
            this.matrix = matrix;
        }

        public Matrix getMatrix() {
            return matrix;
        }
    }
