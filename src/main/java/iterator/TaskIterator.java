package iterator;

import model.Task;

interface TaskIterator {
    boolean hasNext();
    Task next();
}
