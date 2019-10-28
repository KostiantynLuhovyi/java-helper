package com.lugowoy.helper.utils.checking;

import com.lugowoy.helper.utils.BoundCompareException;
import com.lugowoy.helper.utils.BoundOutOfRangeException;

import static com.lugowoy.helper.utils.BoundOutOfRangeException.*;

/**
 * <p> Created by Konstantin Lugowoy on 08.06.2019
 *
 * @author Konstantin Lugowoy
 * @version 1.3
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

}
