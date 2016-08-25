-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 25-Ago-2016 às 16:08
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
-- Estrutura da tabela `cartao`
--

CREATE TABLE `cartao` (
  `ID_CARTAO` bigint(20) NOT NULL,
  `CD_CARTAO` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cartao`
--

INSERT INTO `cartao` (`ID_CARTAO`, `CD_CARTAO`) VALUES
(15, '0008101901');

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

--
-- Extraindo dados da tabela `entrada`
--

INSERT INTO `entrada` (`ID_ENTRADA`, `DT_ENTRADA`, `NR_QUANTIDADE`, `VL_CUSTO`, `ID_PRODUTO`) VALUES
(16, '2016-08-24 21:57:04', '96.00', '1.00', 12),
(17, '2016-08-24 21:57:23', '78.00', '1.00', 11),
(18, '2016-08-24 21:57:40', '200.00', '1.00', 15),
(19, '2016-08-24 21:57:50', '100.00', '1.00', 16),
(20, '2016-08-24 21:58:00', '24.00', '1.00', 4),
(21, '2016-08-24 21:58:49', '900.00', '1.00', 2),
(22, '2016-08-24 21:58:59', '24.00', '1.00', 6),
(23, '2016-08-24 22:00:03', '12.00', '1.00', 8),
(24, '2016-08-24 22:00:14', '24.00', '1.00', 13),
(25, '2016-08-24 22:00:48', '444.00', '1.00', 7),
(26, '2016-08-24 22:02:13', '270.00', '1.00', 7),
(27, '2016-08-24 22:03:34', '12.00', '1.00', 8),
(28, '2016-08-25 10:12:32', '5.00', '1.00', 18);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `ID_PESSOA` bigint(20) NOT NULL,
  `ID_PESSOA_FISICA` bigint(20) DEFAULT NULL,
  `NR_TELEFONE` varchar(14) DEFAULT NULL,
  `ID_CARTAO` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`ID_PESSOA`, `ID_PESSOA_FISICA`, `NR_TELEFONE`, `ID_CARTAO`) VALUES
(1, 1, '0000000000', NULL),
(11, 9, '0000000000', NULL),
(12, 10, '0000000000', NULL),
(13, 11, '0000000000', NULL),
(14, 12, '0000000000', NULL),
(15, 13, '0000000000', NULL),
(16, 14, '0000000000', NULL),
(17, 15, '0000000000', NULL),
(18, 16, '0000000000', NULL),
(19, 17, '0000000000', NULL),
(20, 18, '0000000000', NULL),
(21, 19, '0000000000', NULL),
(22, 20, '0000000000', NULL),
(23, 21, '0000000000', NULL),
(24, 22, '0000000000', NULL),
(25, 23, '0000000000', NULL),
(26, 24, '0000000000', NULL),
(27, 25, '0000000000', NULL),
(28, 26, '0000000000', NULL),
(29, 27, '0000000000', NULL),
(30, 28, '0000000000', NULL),
(31, 29, '0000000000', NULL),
(32, 30, '0000000000', NULL),
(33, 31, '0000000000', NULL),
(34, 32, '0000000000', NULL),
(35, 33, '0000000000', NULL),
(36, 34, '0000000000', NULL),
(37, 35, '0000000000', NULL),
(38, 36, '0000000000', NULL),
(39, 37, '0000000000', NULL),
(40, 38, '0000000000', NULL),
(41, 39, '0000000000', NULL),
(42, 40, '0000000000', NULL),
(43, 41, '0000000000', NULL),
(44, 42, '0000000000', NULL),
(45, 43, '0000000000', NULL),
(46, 44, '0000000000', NULL),
(47, 45, '0000000000', NULL),
(48, 46, '0000000000', NULL),
(49, 47, '0000000000', NULL),
(50, 48, '0000000000', NULL),
(51, 49, '0000000000', NULL),
(52, 50, '0000000000', NULL),
(53, 51, '0000000000', NULL),
(54, 52, '0000000000', NULL),
(55, 53, '0000000000', NULL),
(56, 54, '0000000000', NULL),
(57, 55, '0000000000', NULL),
(58, 56, '0000000000', NULL),
(59, 57, '0000000000', NULL),
(60, 58, '0000000000', NULL),
(61, 59, '0000000000', NULL),
(62, 60, '0000000000', NULL),
(63, 61, '0000000000', NULL),
(64, 62, '0000000000', NULL),
(65, 63, '0000000000', NULL),
(66, 64, '0000000000', NULL),
(67, 65, '0000000000', NULL),
(68, 66, '0000000000', NULL),
(69, 67, '0000000000', NULL),
(70, 68, '0000000000', NULL),
(71, 69, '0000000000', NULL),
(72, 70, '0000000000', NULL),
(73, 71, '0000000000', NULL),
(74, 72, '0000000000', NULL),
(75, 73, '0000000000', NULL),
(76, 74, '0000000000', NULL),
(77, 75, '0000000000', NULL),
(78, 76, '0000000000', NULL),
(79, 77, '0000000000', NULL),
(80, 78, '0000000000', NULL),
(81, 79, '0000000000', NULL),
(82, 80, '0000000000', NULL),
(83, 81, '0000000000', NULL),
(84, 82, '0000000000', NULL),
(85, 83, '0000000000', NULL),
(86, 84, '0000000000', NULL),
(87, 85, '0000000000', NULL),
(88, 86, '0000000000', NULL),
(89, 87, '0000000000', NULL),
(90, 88, '0000000000', NULL),
(91, 89, '0000000000', NULL),
(92, 90, '0000000000', NULL),
(93, 91, '0000000000', NULL),
(94, 92, '0000000000', NULL),
(95, 93, '0000000000', NULL),
(96, 94, '0000000000', NULL),
(97, 95, '0000000000', NULL),
(98, 96, '0000000000', NULL),
(99, 97, '0000000000', NULL),
(100, 98, '0000000000', NULL),
(101, 99, '0000000000', NULL),
(102, 100, '0000000000', NULL),
(103, 101, '0000000000', NULL),
(104, 102, '0000000000', NULL),
(105, 103, '0000000000', NULL),
(106, 104, '0000000000', NULL),
(107, 105, '0000000000', NULL),
(108, 106, '0000000000', NULL),
(109, 107, '0000000000', NULL),
(110, 108, '0000000000', NULL),
(111, 109, '0000000000', NULL),
(112, 110, '0000000000', NULL),
(113, 111, '0000000000', NULL),
(114, 112, '0000000000', NULL),
(115, 113, '0000000000', NULL),
(116, 114, '0000000000', NULL),
(117, 115, '0000000000', NULL),
(118, 116, '0000000000', NULL),
(119, 117, '0000000000', NULL),
(120, 118, '0000000000', NULL),
(121, 119, '0000000000', NULL),
(122, 120, '0000000000', NULL),
(123, 121, '0000000000', NULL),
(124, 122, '0000000000', NULL),
(125, 123, '0000000000', NULL),
(126, 124, '0000000000', NULL),
(127, 125, '0000000000', NULL),
(128, 126, '0000000000', NULL),
(129, 127, '0000000000', NULL),
(130, 128, '0000000000', NULL),
(131, 129, '0000000000', NULL),
(132, 130, '0000000000', NULL),
(133, 131, '0000000000', NULL),
(134, 132, '0000000000', NULL),
(135, 133, '0000000000', NULL),
(136, 134, '0000000000', NULL),
(137, 135, '0000000000', NULL),
(138, 136, '0000000000', NULL),
(139, 137, '0000000000', NULL),
(140, 138, '0000000000', NULL),
(141, 139, '0000000000', NULL),
(142, 140, '0000000000', NULL),
(143, 141, '0000000000', NULL),
(144, 142, '0000000000', NULL),
(145, 143, '0000000000', NULL),
(146, 144, '0000000000', NULL),
(147, 145, '0000000000', NULL),
(148, 146, '0000000000', NULL),
(149, 147, '0000000000', NULL),
(150, 148, '0000000000', NULL),
(151, 149, '0000000000', NULL),
(152, 150, '0000000000', NULL),
(153, 151, '0000000000', NULL),
(154, 152, '0000000000', NULL),
(155, 153, '0000000000', NULL),
(156, 154, '0000000000', NULL),
(157, 155, '0000000000', NULL),
(158, 156, '0000000000', NULL),
(159, 157, '0000000000', NULL),
(160, 158, '0000000000', NULL),
(161, 159, '0000000000', NULL),
(162, 160, '0000000000', NULL),
(163, 161, '0000000000', NULL),
(164, 162, '0000000000', NULL),
(165, 163, '0000000000', NULL),
(167, 165, '0000000000', NULL),
(168, 166, '0000000000', NULL),
(169, 167, '0000000000', NULL),
(170, 168, '0000000000', NULL),
(171, 169, '0000000000', NULL),
(172, 170, '0000000000', NULL),
(173, 171, '0000000000', NULL),
(174, 172, '0000000000', NULL),
(175, 173, '0000000000', NULL),
(176, 174, '0000000000', NULL),
(177, 175, '0000000000', NULL),
(178, 176, '0000000000', NULL),
(179, 177, '0000000000', NULL),
(180, 178, '0000000000', NULL),
(181, 179, '0000000000', NULL),
(182, 180, '0000000000', NULL),
(183, 181, '0000000000', NULL),
(184, 182, '0000000000', NULL),
(185, 183, '0000000000', NULL),
(186, 184, '0000000000', NULL),
(188, 186, '0000000000', 15);

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
(1, '00000000000', 'Leandro Máximo Cunha'),
(9, '00000000000', 'Mariane Oliveira Medeiro'),
(10, '00000000000', 'Levy Gonçalves da Cunha'),
(11, '00000000000', 'Filma Faria da Cunha'),
(12, '00000000000', 'Eloísa de Fátima Cunha'),
(13, '00000000000', 'Bárbara Cunha de Freitas'),
(14, '00000000000', 'Edward Gonçalves da Cunha'),
(15, '00000000000', 'Vitor Hugo Cunha de Freitas'),
(16, '00000000000', 'Elizabete Matos Cunha'),
(17, '00000000000', 'Eliane Lourdes Cunha Freitas'),
(18, '00000000000', 'Felipe Matos Cunha'),
(19, '00000000000', 'Rogério José Gomes de Freitas'),
(20, '00000000000', 'Bruno Matos da Cunha'),
(21, '00000000000', 'Amanda Cunha Gomes de Freitas'),
(22, '00000000000', 'Edgard Gonçalves da Cunha'),
(23, '00000000000', 'Guilherme Cunha Gomes de Freitas'),
(24, '00000000000', 'Ernani Gonçalves da Cunha'),
(25, '00000000000', 'Maria Vilânia Mendes Cunha'),
(26, '00000000000', 'Marielma Soares de Oliveira da Cunha'),
(27, '00000000000', 'João Paulo Mendes Cunha'),
(28, '00000000000', 'Isabela de Oliveira da Cunha'),
(29, '00000000000', 'Edvânia Aparecida Cunha Gomes'),
(30, '00000000000', 'Mauro Sérgio Gomes'),
(31, '00000000000', 'Rafaela de Oliveira da Cunha'),
(32, '00000000000', 'Avner Sérgio Cunha Gomes'),
(33, '00000000000', 'Nayla Cunha Gomes'),
(34, '00000000000', 'Leony Gonçalves da Cunha'),
(35, '00000000000', 'Edimar Leoni da Cunha'),
(36, '00000000000', 'Zaida Santana da Cunha'),
(37, '00000000000', 'Gerrana Campos Favieiro'),
(38, '00000000000', 'Eder Leoni dos Anjos'),
(39, '00000000000', 'Iveta Gomes dos Anjos'),
(40, '00000000000', 'Thalita Gomes dos Anjos'),
(41, '00000000000', 'Gabriel Gomes dos Anjos'),
(42, '00000000000', 'Pedro Henrique Favieiro da Cunha'),
(43, '00000000000', 'Leonardo Gomes dos Anjos'),
(44, '00000000000', 'Thaís Godoi Silva'),
(45, '00000000000', 'Mateus Favieiro da Cunha'),
(46, '00000000000', 'Edilson Leoni da Cunha'),
(47, '00000000000', 'Lucca Godoi dos Anjos'),
(48, '00000000000', 'Marilene Rodrigues da Cunha'),
(49, '00000000000', 'Edna Leoni da Cunha Camilo'),
(50, '00000000000', 'Henrique  Leoni Rodrigues da Cunha'),
(51, '00000000000', 'Vandeli Camilo Ricardo (Lelé)'),
(52, '00000000000', 'Jaqueline da Cunha Camilo'),
(53, '00000000000', 'Anelise da Cunha Camilo'),
(54, '00000000000', 'Lucas Pereira Mariano'),
(55, '00000000000', 'Helena Beatriz Rodrigues da Cunha'),
(56, '00000000000', 'Laiana Lacerda Cunha'),
(57, '00000000000', 'Fernando César de Oliveira Alves'),
(58, '00000000000', 'Claúdia Leoni da Cunha Mendonça'),
(59, '00000000000', 'Marcus Barbosa Mendonça'),
(60, '00000000000', 'Paulo Leoni da Cunha'),
(61, '00000000000', 'Lívia da Cunha Mendonça'),
(62, '00000000000', 'Letícia da Cunha Mendonça'),
(63, '00000000000', 'Ana Virgínia Braga Santiago'),
(64, '00000000000', 'Leonídio da Cunha'),
(65, '00000000000', 'Clênio Jona da Cunha'),
(66, '00000000000', 'Ieda Maria da Cunha'),
(67, '00000000000', 'Joice de Souza Braga Cunha'),
(68, '00000000000', 'João Marcos da Cunha'),
(69, '00000000000', 'Jéssica Carolaine de Souza Cunha'),
(70, '00000000000', 'Elaine Reis Batista'),
(71, '00000000000', 'Cácio Aurélio da Cunha'),
(72, '00000000000', 'Sarah Reis Cunha'),
(73, '00000000000', 'Sophia Reis Cunha'),
(74, '00000000000', 'Maria José Ferreira Cunha'),
(75, '00000000000', 'Raquel Reis Cunha'),
(76, '00000000000', 'Kamila Ferreira Cunha'),
(77, '00000000000', 'Kairo Ferreira Cunha'),
(78, '00000000000', 'Kaique Ferreira Cunha'),
(79, '00000000000', 'Murilo Gomes da Cunha'),
(80, '00000000000', 'Carla Caroliny Ferreira Cunha'),
(81, '00000000000', 'Gabriela Gomes Cunha'),
(82, '00000000000', 'Guilherme Gomes da Cunha'),
(83, '00000000000', 'Ângela Gabriela Arruda Cunha'),
(84, '00000000000', 'Leondes Gonçalves da Cunha'),
(85, '00000000000', 'Daniela Gonçalves da Cunha'),
(86, '00000000000', 'Maria da Conceição da Cunha (Sãozinha)'),
(87, '00000000000', 'Celso Manica'),
(88, '00000000000', 'Marcélio Gonçalves da Cunha'),
(89, '00000000000', 'Cristian Mendes Costa Júnior'),
(90, '00000000000', 'Gislene Maria Gomes'),
(91, '00000000000', 'Luciano Gonçalves da Cunha'),
(92, '00000000000', 'Maria Fernanda Pires Cunha'),
(93, '00000000000', 'Cristiane da Graças Borges Cunha'),
(94, '00000000000', 'Hícaro Gaia Cunha'),
(95, '00000000000', 'Mateus Borges Cunha'),
(96, '00000000000', 'Gabriel Borges Cunha'),
(97, '00000000000', 'Aline de Sousa Rocha Cunha'),
(98, '00000000000', 'Arthur Pessoa Cunha'),
(99, '00000000000', 'Élcio Gonçalves da Cunha'),
(100, '00000000000', 'Marcella Gaia Cunha'),
(101, '00000000000', 'Caren Cristiane do Couto Cunha'),
(102, '00000000000', 'Lucas Couto Cunha'),
(103, '00000000000', 'Fernando Gonçalves de Oliveira'),
(104, '00000000000', 'Laura Couto Cunha'),
(105, '00000000000', 'Maria Fernanda Gaia Oliveira'),
(106, '00000000000', 'Maria de Lourdes de Freitas'),
(107, '00000000000', 'Sandra Lisboa de Freitas'),
(108, '00000000000', 'Sandro Lisboa de Freitas'),
(109, '00000000000', 'Tereza Cristina de Araújo Freitas'),
(110, '00000000000', 'Rayanne Freitas Cardoso de Andrade'),
(111, '00000000000', 'Rebeca de Araújo Freitas'),
(112, '00000000000', 'Rayssa Freitas Cardoso de Andrade'),
(113, '00000000000', 'Juliana de Araújo Freitas Leão'),
(114, '00000000000', 'Mateus Freitas dos Santos'),
(115, '00000000000', 'João Carlos Leão da Silva'),
(116, '00000000000', 'Sidney Antônio de Freitas'),
(117, '00000000000', 'Luiz Antônio Fernandes Freitas'),
(118, '00000000000', 'Inácia Roselene Fernandes Diógenes'),
(119, '00000000000', 'Douglas Brasil de Freitas'),
(120, '00000000000', 'Liberino da Cunha'),
(121, '00000000000', 'Liberino da Cunha Júnior'),
(122, '00000000000', 'João Pedro da Cunha Silva'),
(123, '00000000000', 'Joana Francisca Alves Medeiros'),
(124, '00000000000', 'Sara Amorim da Cunha'),
(125, '00000000000', 'Maria Eduarda da Cunha Silva'),
(126, '00000000000', 'Fabiana Amorim da Cunha'),
(127, '00000000000', 'Elmo Pereira Luz'),
(128, '00000000000', 'Lilian Amorim da Cunha de Carvalho'),
(129, '00000000000', 'Mariana da Cunha Pereira Luz'),
(130, '00000000000', 'Marcos Aurélio V. de Carvalho'),
(131, '00000000000', 'Daniel da Cunha Pereira Luz'),
(132, '00000000000', 'Iasmyn Fiama da Cunha de Carvalho'),
(133, '00000000000', 'Izaac Angelo'),
(134, '00000000000', 'Maria Júlia da Cunha Pereira'),
(135, '00000000000', 'Susana da Cunha Pereira Luz'),
(136, '00000000000', 'Eduardo da Cunha Pereira Luz'),
(137, '00000000000', 'Laércio Golçalves da Cunha'),
(138, '00000000000', 'Maria Júlia de Souza Cunha'),
(139, '00000000000', 'Lucas Souza Cunha'),
(140, '00000000000', 'Larissa Souza Cunha'),
(141, '00000000000', 'Mariana Neves Xavier'),
(142, '00000000000', 'André Fidelis de Oliveira'),
(143, '00000000000', 'Isabel Versiani Xavier Cunha'),
(144, '00000000000', 'Samuel Souza Cunha'),
(145, '00000000000', 'Angelica Versiani Mota'),
(146, '00000000000', 'Elisa Cunha Oliveira'),
(147, '00000000000', 'Maria Aparecida Cunha Alves'),
(148, '00000000000', 'Anderson Cunha Alves'),
(149, '00000000000', 'Mariane Oliveira Santos'),
(150, '00000000000', 'Nilton Augusto Alves'),
(151, '00000000000', 'Helena Oliveira Alves'),
(152, '00000000000', 'Alyne Cunha Oliveira'),
(153, '00000000000', 'Adriane Cunha Alves Silva'),
(154, '00000000000', 'Hebert Silva de Oliveira'),
(155, '00000000000', 'Gilberto Antônio da Silva'),
(156, '00000000000', 'Gabriel Augusto Cunha de Olivera'),
(157, '00000000000', 'Geovana Cunha Alves Silva'),
(158, '00000000000', 'Felipe Augusto Cunha de Oliveira'),
(159, '00000000000', 'Miguel Augusto Cunha de Oliveira'),
(160, '00000000000', 'Augusto Cunha Alves Silva'),
(161, '00000000000', 'Maria de Fátima Cunha Gomes'),
(162, '00000000000', 'Matheus Veríssimo Cunha Gomes'),
(163, '00000000000', 'Veríssimo Gomes Neto'),
(165, '00000000000', 'Bruno Veríssimo Cunha Gomes'),
(166, '00000000000', 'Luciana Santos'),
(167, '00000000000', 'Gustavo Veríssimo Cunha Gomes'),
(168, '00000000000', 'Pedro Veríssimo Santos Cunha'),
(169, '00000000000', 'José Vitor Santos Cunha'),
(170, '00000000000', 'Lourenço Gonçalves da Cunha'),
(171, '00000000000', 'Karolina Máximo Cunha'),
(172, '00000000000', 'Rosilene Cordeiro Máximo Cunha'),
(173, '00000000000', 'Amanda Máximo Cunha'),
(174, '00000000000', 'Thiago Martins Rodrigues'),
(175, '00000000000', 'Lourival Gonçalves da Cunha'),
(176, '00000000000', 'Ana Carolina da Costa Cunha'),
(177, '00000000000', 'Sebastiana Alves de Jesus'),
(178, '00000000000', 'Cairo Henrique da Costa Cunha'),
(179, '00000000000', 'Diego Gonçalves da Costa Cunha'),
(180, '00000000000', 'Marcelle Albernaz Siqueira Cunha'),
(181, '00000000000', 'Leandro Gonçalves da Costa Cunha'),
(182, '00000000000', 'Sabrina Alves Cunha Torres'),
(183, '00000000000', 'Erick Levy da Costa Cunha'),
(184, '00000000000', 'Rafael da Silva Torres'),
(186, '00000000000', 'Teste Teste Teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `ID_PRODUTO` bigint(20) NOT NULL,
  `DS_PRODUTO` varchar(200) DEFAULT NULL,
  `DS_NOME_PRODUTO` varchar(60) NOT NULL,
  `VL_VENDA` decimal(19,2) NOT NULL,
  `CAMINHO_IMAGEM` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`ID_PRODUTO`, `DS_PRODUTO`, `DS_NOME_PRODUTO`, `VL_VENDA`, `CAMINHO_IMAGEM`) VALUES
(2, 'Cerveja Antartica, Skol e Brahma Zero', 'Cerveja ', '2.50', 'skol.png'),
(4, 'Agua com Gás', 'Agua com Gás', '1.50', 'agua.png'),
(6, 'Energetico Forever', 'Energetico', '7.50', 'energetico.png'),
(7, 'Refrigerante Lata Mini e Suco Caixinha', 'Refrigerante Lata e Suco', '1.50', 'refri_lata.png'),
(8, 'Refrigerante 1.5 Lts', 'Refrigerante 1.5 Lts', '4.50', 'refri_2l.png'),
(11, '51 Ice', '51 Ice', '3.00', '51_ice.png'),
(12, 'Smirnoff Ice', 'Smirnoff Ice', '4.00', 'smirnoff_ice.png'),
(13, 'Refrigerante 1L', 'Refrigerante 1L', '2.50', NULL),
(14, 'Truque', 'Truque', '5.00', 'truque.png'),
(15, 'Picole e Chupe-Chupe', 'Picole e Chupe-Chupe', '1.50', 'picole.png'),
(16, 'Sorvete', 'Sorvete', '2.80', 'sorvete.png'),
(17, 'Vodka Smirnoff', 'Dose Vodka', '3.00', NULL),
(18, 'Teste', '01 Teste', '1.00', NULL);

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
  `ID_PRODUTO` bigint(20) DEFAULT NULL,
  `ST_ATIVO` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `saida`
--

INSERT INTO `saida` (`ID_SAIDA`, `DT_SAIDA`, `NR_QUANTIDADE`, `VL_SAIDA`, `ID_PESSOA`, `ID_PRODUTO`, `ST_ATIVO`) VALUES
(10, '2016-08-25 10:49:51', '1.00', '1.00', 188, 18, 0),
(11, '2016-08-25 10:57:01', '1.00', '1.00', 188, 18, 1),
(12, '2016-08-25 11:02:44', '1.00', '1.00', 188, 18, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cartao`
--
ALTER TABLE `cartao`
  ADD PRIMARY KEY (`ID_CARTAO`),
  ADD UNIQUE KEY `UK_1fpwttfso690rult4vph1wgt3` (`CD_CARTAO`);

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
  ADD KEY `FK5y7hjf3x84wpr43o77o51dju4` (`ID_PESSOA_FISICA`),
  ADD KEY `FKih3non202f64joxwnnhfh4d56` (`ID_CARTAO`);

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
-- AUTO_INCREMENT for table `cartao`
--
ALTER TABLE `cartao`
  MODIFY `ID_CARTAO` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `entrada`
--
ALTER TABLE `entrada`
  MODIFY `ID_ENTRADA` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `ID_PESSOA` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=189;
--
-- AUTO_INCREMENT for table `pessoa_fisica`
--
ALTER TABLE `pessoa_fisica`
  MODIFY `ID_PESSOA_FISICA` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=187;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `ID_PRODUTO` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `saida`
--
ALTER TABLE `saida`
  MODIFY `ID_SAIDA` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
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
  ADD CONSTRAINT `FK5y7hjf3x84wpr43o77o51dju4` FOREIGN KEY (`ID_PESSOA_FISICA`) REFERENCES `pessoa_fisica` (`ID_PESSOA_FISICA`),
  ADD CONSTRAINT `FKih3non202f64joxwnnhfh4d56` FOREIGN KEY (`ID_CARTAO`) REFERENCES `cartao` (`ID_CARTAO`);

--
-- Limitadores para a tabela `saida`
--
ALTER TABLE `saida`
  ADD CONSTRAINT `FK4ucmitloxa10g9sn21k7nl5ns` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID_PRODUTO`),
  ADD CONSTRAINT `FK7sx7q865wlm368jb607ojmu0s` FOREIGN KEY (`ID_PESSOA`) REFERENCES `pessoa` (`ID_PESSOA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
