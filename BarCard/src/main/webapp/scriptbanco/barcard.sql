-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 21-Ago-2016 às 00:39
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `barcard`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `entrada`
--

CREATE TABLE `entrada` (
  `ID_ENTRADA` bigint(20) NOT NULL,
  `DT_ENTRADA` datetime NOT NULL,
  `NR_QUANTIDADE` decimal(19,2) NOT NULL,
  `VL_CUSTO` decimal(19,2) NOT NULL,
  `ID_PRODUTO` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `ID_PESSOA` bigint(20) NOT NULL,
  `ID_PESSOA_FISICA` bigint(20) DEFAULT NULL,
  `NR_TELEFONE` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`ID_PESSOA`, `ID_PESSOA_FISICA`, `NR_TELEFONE`) VALUES
(1, 1, '3899614111'),
(6, 4, '3899614111'),
(9, 7, '9999999999');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_fisica`
--

CREATE TABLE `pessoa_fisica` (
  `ID_PESSOA_FISICA` bigint(20) NOT NULL,
  `NR_CPF` varchar(14) DEFAULT NULL,
  `DS_NOME` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa_fisica`
--

INSERT INTO `pessoa_fisica` (`ID_PESSOA_FISICA`, `NR_CPF`, `DS_NOME`) VALUES
(1, '09569299665', 'Leandro Máximo Cunha'),
(4, '09569299665', 'Teste'),
(7, '111111111', 'Teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `ID_PRODUTO` bigint(20) NOT NULL,
  `DS_PRODUTO` varchar(200) DEFAULT NULL,
  `DS_NOME_PRODUTO` varchar(60) NOT NULL,
  `VL_VENDA` decimal(19,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`ID_PRODUTO`, `DS_PRODUTO`, `DS_NOME_PRODUTO`, `VL_VENDA`) VALUES
(1, 'teste', 'Teste', '12.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `saida`
--

CREATE TABLE `saida` (
  `ID_SAIDA` bigint(20) NOT NULL,
  `DT_SAIDA` datetime DEFAULT NULL,
  `NR_QUANTIDADE` decimal(19,2) NOT NULL,
  `VL_SAIDA` decimal(19,2) NOT NULL,
  `ID_PESSOA` bigint(20) DEFAULT NULL,
  `ID_PRODUTO` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`ID_ENTRADA`),
  ADD KEY `FK3ubkf36pf3ffk1evtm3vxm0vn` (`ID_PRODUTO`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`ID_PESSOA`),
  ADD KEY `FK5y7hjf3x84wpr43o77o51dju4` (`ID_PESSOA_FISICA`);

--
-- Indexes for table `pessoa_fisica`
--
ALTER TABLE `pessoa_fisica`
  ADD PRIMARY KEY (`ID_PESSOA_FISICA`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`ID_PRODUTO`);

--
-- Indexes for table `saida`
--
ALTER TABLE `saida`
  ADD PRIMARY KEY (`ID_SAIDA`),
  ADD KEY `FK7sx7q865wlm368jb607ojmu0s` (`ID_PESSOA`),
  ADD KEY `FK4ucmitloxa10g9sn21k7nl5ns` (`ID_PRODUTO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `entrada`
--
ALTER TABLE `entrada`
  MODIFY `ID_ENTRADA` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `ID_PESSOA` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `pessoa_fisica`
--
ALTER TABLE `pessoa_fisica`
  MODIFY `ID_PESSOA_FISICA` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `ID_PRODUTO` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `saida`
--
ALTER TABLE `saida`
  MODIFY `ID_SAIDA` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `FK3ubkf36pf3ffk1evtm3vxm0vn` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID_PRODUTO`);

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `FK5y7hjf3x84wpr43o77o51dju4` FOREIGN KEY (`ID_PESSOA_FISICA`) REFERENCES `pessoa_fisica` (`ID_PESSOA_FISICA`);

--
-- Limitadores para a tabela `saida`
--
ALTER TABLE `saida`
  ADD CONSTRAINT `FK4ucmitloxa10g9sn21k7nl5ns` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID_PRODUTO`),
  ADD CONSTRAINT `FK7sx7q865wlm368jb607ojmu0s` FOREIGN KEY (`ID_PESSOA`) REFERENCES `pessoa` (`ID_PESSOA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
