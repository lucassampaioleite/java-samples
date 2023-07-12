package services;

import java.util.Collections;
import java.util.List;

public class CalculationService {

	public static <T extends Comparable<? super T>> T max(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty!");
		}
		return Collections.max(list);
	}

}
