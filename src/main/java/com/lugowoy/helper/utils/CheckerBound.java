package com.lugowoy.helper.utils;

import static com.lugowoy.helper.utils.BoundOutOfRangeException.*;

/**
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.6.6
 */
//todo write doc's
public interface CheckerBound {

    static boolean isPositiveBound(Number bound) {
        if (bound != null) {
            if (bound.doubleValue() > 0) {
                return true;
            } else {
                throw new BoundOutOfRangeException(MSG_NEGATIVE_BOUND);
            }
        } else {
            throw new NullPointerException("Bound is null.");
        }
    }

    static boolean isPositiveBound(int bound) {
        if (bound > 0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_NEGATIVE_BOUND);
        }
    }

    static boolean isPositiveBound(double bound) {
        if (bound > 0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_NEGATIVE_BOUND);
        }
    }

    static boolean isNegativeBound(Number bound) {
        if (bound != null) {
            if (bound.doubleValue() < 0) {
                return true;
            } else {
                throw new BoundOutOfRangeException(MSG_POSITIVE_BOUND);
            }
        } else {
            throw new NullPointerException("Bound is null.");
        }
    }

    static boolean isNegativeBound(int bound) {
        if (bound < 0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_POSITIVE_BOUND);
        }
    }

    static boolean isNegativeBound(double bound) {
        if (bound < 0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_POSITIVE_BOUND);
        }
    }

    static boolean isZero(Number bound) {
        if (bound != null) {
            if (bound.doubleValue() == 0.0) {
                return true;
            } else {
                throw new BoundOutOfRangeException(MSG_NON_ZERO);
            }
        } else {
            throw new NullPointerException("Bound is null.");
        }
    }

    static boolean isZero(int bound) {
        if (bound == 0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_NON_ZERO);
        }
    }

    static boolean isZero(double bound) {
        if (bound == 0.0) {
            return true;
        } else {
            throw new BoundOutOfRangeException(MSG_NON_ZERO);
        }
    }

    static boolean isCorrectBounds(Number bound) {
        if (bound != null) {
            if (bound.doubleValue() >= Integer.MIN_VALUE && bound.doubleValue() <= Integer.MAX_VALUE) {
                return true;
            } else {
                throw new BoundOutOfRangeException("Bound is out of range (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ").");
            }
        } else {
            throw new NullPointerException("Bound is null.");
        }
    }

    static boolean isCorrectBounds(int bound) {
        if (bound >= Integer.MIN_VALUE && bound <= Integer.MAX_VALUE) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound is out of range (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ").");
        }
    }

    static boolean isCorrectBounds(double bound) {
        if (bound >= Integer.MIN_VALUE && bound <= Integer.MAX_VALUE) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound is out of range (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ").");
        }
    }

    static boolean isCorrectBounds(Number bound, Number upperBound) {
        if (bound != null) {
            if (upperBound != null) {
                if (bound.doubleValue() >= 0 && bound.doubleValue() <= upperBound.doubleValue()) {
                    return true;
                } else {
                    throw new BoundOutOfRangeException("Bound is out of range (0 - " + Integer.MAX_VALUE + ").");
                }
            } else {
                throw new NullPointerException("Upper bound is null.");
            }
        } else {
            throw new NullPointerException("Bound is null.");
        }
    }

    static boolean isCorrectBounds(Number bound, Number upperBound, String msgException) {
        if (bound != null) {
            if (upperBound != null) {
                if (bound.doubleValue() >= 0 && bound.doubleValue() <= upperBound.doubleValue()) {
                    return true;
                } else {
                    throw new BoundOutOfRangeException(msgException);
                }
            } else {
                throw new NullPointerException("Upper bound is null.");
            }
        } else {
            throw new NullPointerException("Bound is null.");
        }
    }

    static boolean isCorrectBounds(int bound, int upperBound) {
        if (bound >= 0 && bound <= upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound is out of range (0 - " + Integer.MAX_VALUE + ").");
        }
    }

    static boolean isCorrectBounds(int bound, int upperBound, String msgException) {
        if (bound >= 0 && bound <= upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException(msgException);
        }
    }

    static boolean isCorrectBounds(double bound, double upperBound) {
        if (bound >= 0.0 && bound <= upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound is out of range (0 - " + Integer.MAX_VALUE + ").");
        }
    }

    static boolean isCorrectBounds(double bound, double upperBound, String msgException) {
        if (bound >= 0.0 && bound <= upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException(msgException);
        }
    }

    static boolean isCorrectBounds(Number bound, Number lowerBound, Number upperBound) {
        if (bound != null) {
            if (lowerBound != null) {
                if (upperBound != null) {
                    if (bound.doubleValue() >= lowerBound.doubleValue() && bound.doubleValue() <= upperBound.doubleValue()) {
                        return true;
                    } else {
                        throw new BoundOutOfRangeException("Bound value is out of range values.");
                    }
                } else {
                    throw new NullPointerException("Upper bound is null");
                }
            } else {
                throw new NullPointerException("Lower bound is null");
            }
        } else {
            throw new NullPointerException("Bound is null");
        }
    }

    static boolean isCorrectBounds(Number bound, Number lowerBound, Number upperBound, String msgException) {
        if (bound != null) {
            if (lowerBound != null) {
                if (upperBound != null) {
                    if (bound.doubleValue() >= lowerBound.doubleValue() && bound.doubleValue() <= upperBound.doubleValue()) {
                        return true;
                    } else {
                        throw new BoundOutOfRangeException(msgException);
                    }
                } else {
                    throw new NullPointerException("Upper bound is null");
                }
            } else {
                throw new NullPointerException("Lower bound is null");
            }
        } else {
            throw new NullPointerException("Bound is null");
        }
    }

    static boolean isCorrectBounds(int bound, int lowerBound, int upperBound) {
        if (bound >= lowerBound && bound <= upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound value is out of range values.");
        }
    }

    static boolean isCorrectBounds(int bound, int lowerBound, int upperBound, String msgException) {
        if (bound >= lowerBound && bound <= upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException(msgException);
        }
    }

    static boolean isCorrectBounds(double bound, double lowerBound, double upperBound) {
        if (bound >= lowerBound && bound <= upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException("Bound value is out of range values.");
        }
    }

    static boolean isCorrectBounds(double bound, double lowerBound, double upperBound, String msgException) {
        if (bound >= lowerBound && bound <= upperBound) {
            return true;
        } else {
            throw new BoundOutOfRangeException(msgException);
        }
    }

    static boolean isLowerBoundEqualThanUpperBound(Number lowerBound, Number upperBound) {
        if (lowerBound != null) {
            if (upperBound != null) {
                if (lowerBound.doubleValue() == upperBound.doubleValue()) {
                    return true;
                } else {
                    throw new BoundCompareException("Lower bound is not equal to upper bound");
                }
            } else {
                throw new NullPointerException("Upper bound is null.");
            }
        } else {
            throw new NullPointerException("Lower bound is null.");
        }
    }

    static boolean isLowerBoundEqualThanUpperBound(int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is not equal to upper bound");
        }
    }

    static boolean isLowerBoundEqualThanUpperBound(double lowerBound, double upperBound) {
        if (lowerBound == upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is not equal to upper bound");
        }
    }

    static boolean isLowerBoundLessThanUpperBound(Number lowerBound, Number upperBound) {
        if (lowerBound != null) {
            if (upperBound != null) {
                if (lowerBound.doubleValue() < upperBound.doubleValue()) {
                    return true;
                } else {
                    throw new BoundCompareException("Lower bound is greater than upper bound.");
                }
            } else {
                throw new NullPointerException("Upper bound is null.");
            }
        } else {
            throw new NullPointerException("Lower bound is null.");
        }
    }

    static boolean isLowerBoundLessThanUpperBound(int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is greater than upper bound.");
        }
    }

    static boolean isLowerBoundLessThanUpperBound(double lowerBound, double upperBound) {
        if (lowerBound < upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is greater than upper bound.");
        }
    }

    static boolean isLowerBoundGreaterThanUpperBound(Number lowerBound, Number upperBound) {
        if (lowerBound != null) {
            if (upperBound != null) {
                if (lowerBound.doubleValue() > upperBound.doubleValue()) {
                    return true;
                } else {
                    throw new BoundCompareException("Lower bound is less than upper bound.");
                }
            } else {
                throw new NullPointerException("Upper bound is null");
            }
        } else {
            throw new NullPointerException("Lower bound is null.");
        }
    }

    static boolean isLowerBoundGreaterThanUpperBound(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is less than upper bound.");
        }
    }

    static boolean isLowerBoundGreaterThanUpperBound(double lowerBound, double upperBound) {
        if (lowerBound > upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is less than upper bound.");
        }
    }

    static boolean isLowerBoundLessOrEqualThanUpperBound(Number lowerBound, Number upperBound) {
        if (lowerBound != null) {
            if (upperBound != null) {
                if (lowerBound.doubleValue() <= upperBound.doubleValue()) {
                    return true;
                } else {
                    throw new BoundCompareException("Lower bound is greater or not equal than upper bound.");
                }
            } else {
                throw new NullPointerException("Upper bound is null.");
            }
        } else {
            throw new NullPointerException("Lower bound is null.");
        }
    }

    static boolean isLowerBoundLessOrEqualThanUpperBound(int lowerBound, int upperBound) {
        if (lowerBound <= upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is greater or not equal than upper bound.");
        }
    }

    static boolean isLowerBoundLessOrEqualThanUpperBound(double lowerBound, double upperBound) {
        if (lowerBound <= upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is greater or not equal than upper bound.");
        }
    }

    static boolean isLowerBoundGreaterOrEqualThanUpperBound(Number lowerBound, Number upperBound) {
        if (lowerBound != null) {
            if (upperBound != null) {
                if (lowerBound.doubleValue() >= upperBound.doubleValue()) {
                    return true;
                } else {
                    throw new BoundCompareException("Lower bound is less or not equal than upper bound.");
                }
            } else {
                throw new NullPointerException("Upper bound is null.");
            }
        } else {
            throw new NullPointerException("Lower bound is null.");
        }
    }

    static boolean isLowerBoundGreaterOrEqualThanUpperBound(int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is less or not equal than upper bound.");
        }
    }

    static boolean isLowerBoundGreaterOrEqualThanUpperBound(double lowerBound, double upperBound) {
        if (lowerBound >= upperBound) {
            return true;
        } else {
            throw new BoundCompareException("Lower bound is less or not equal than upper bound.");
        }
    }

}
