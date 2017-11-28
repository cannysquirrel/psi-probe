/**
 * Licensed under the GPL License. You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE.
 */
package psiprobe.tools.logging.jdk;

import java.io.File;

import psiprobe.tools.Instruments;

public class Jdk14FileHandlerAccessor extends Jdk14HandlerAccessor {

	private static final int LATEST_FILE_INDEX = 0;

	/**
	 * Currently, we only access the latest log file with index 0.
	 */
	@Override
	public File getFile() {
		String pattern = (String) Instruments.getField(getTarget(), "pattern");
		String logFilePath = pattern.replace("%g", String.valueOf(LATEST_FILE_INDEX));
		return new File(logFilePath);
	}
}
