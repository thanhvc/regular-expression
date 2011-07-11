/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.common.regex.grammar.builder;

import org.exoplatform.common.regex.grammar.model.CompositeSymbol;
import org.exoplatform.common.regex.grammar.model.NonTerminalSymbol;
import org.exoplatform.common.regex.grammar.model.TerminalSymbol;
import org.exoplatform.common.regex.grammar.exception.InvalidSymbolException;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 7/11/11
 */
public abstract class ProductionRules
{

   abstract public TerminalSymbol mapNTS_TS(NonTerminalSymbol nonTerminal) throws InvalidSymbolException;

   abstract public CompositeSymbol mapNTS_CS(NonTerminalSymbol nonTerminal) throws InvalidSymbolException;

   abstract public CompositeSymbol mapCS_CS(CompositeSymbol compositeSymbol) throws InvalidSymbolException;

}
